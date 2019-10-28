package cn.com.pingtech.senseFace.facade;

import cn.com.pingtech.senseFace.domain.UserInfo;
import cn.com.pingtech.senseFace.exception.SenseFaceException;
import cn.com.pingtech.senseFace.pojo.DB;
import cn.com.pingtech.senseFace.pojo.Image;
import cn.com.pingtech.senseFace.pojo.Image1;
import cn.com.pingtech.senseFace.pojo.SenseFaceImage;
import cn.com.pingtech.senseFace.senseEnums.StaticDBEnum;
import cn.com.pingtech.utils.CheckEmptyUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: psf
 * @Date: 2019/8/30 10:43
 * @Description: 商汤人脸 业务处理，调用事物层service 将控制器  业务层 事物层耦合
 */

@Component
public class SenseFaceFacade {
    private final Logger logger = LoggerFactory.getLogger(SenseFaceFacade.class);
    @Resource
    private RestTemplate restTemplate;

    @Value("${senseFace.static.service.url}")
    private String sernseFaceUrl;//静态人脸服务地址

    @Value("${senseFace.static.db_id_check")
    private String db_id_check;//人脸比对静态库id（人脸核查）

    @Value("${senseFace.static.db_id_login}")
    private String db_id_login;//人脸比对静态库id（人脸登录）

    @Value("${senseFace.static.score}")
    private String score;//人脸比对阈值

    @Value("${senseFace.person.query}")
    private String personUrl;

    //根据图片搜索比中人脸信息
    public UserInfo searchInfoByImage(String base64Image,  String dbType) throws SenseFaceException, Exception {
        ObjectMapper mapper = new ObjectMapper();
        String url = sernseFaceUrl + "/engine/api-wrapper/v1/face/search_image_in_dbs";
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .build()
                .encode()
                .toUri();
        DB db = null;
        SenseFaceImage senseFaceImage = new SenseFaceImage();
        logger.info("dbType:"+dbType);
        if (StaticDBEnum.LOGIN.getValue().equals(dbType)) {
            db = new DB(db_id_login, 1, Double.parseDouble(score));
        } else if (StaticDBEnum.CHECK.getValue().equals(dbType)) {
            db = new DB(db_id_check, 1, Double.parseDouble(score));
        }

        List<DB> dbs = new ArrayList<>();
        dbs.add(db);
        Image1 iamge1 = new Image1("IMAGE_UNKNOWN", base64Image);
        Image image = new Image(iamge1, "LargestFace");
        senseFaceImage.setType("STATIC_FEATURE_DB");
        senseFaceImage.setDbs(dbs);
        senseFaceImage.setImage(image);
        logger.info("search_image_in_dbs接口请求地址和参数：{},{}", url, JSON.toJSONString(senseFaceImage));

        HttpHeaders headers = new HttpHeaders();
       // headers.set("accessToken", accessToken);
        RequestEntity<SenseFaceImage> request =
                new RequestEntity(senseFaceImage, headers, HttpMethod.POST, uri);

        String value = restTemplate.exchange(request, String.class).getBody();
        logger.info("search_image_in_dbs接口返回值:{}", value);
        //TODO 将解析的结果 调用北京人员证件照获取接口、组合成完整的人员信息返回值
        if (CheckEmptyUtil.isNotEmpty(value)) {
            try {
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                Map result = mapper.readValue(value, Map.class);
                UserInfo userInfo = getUserfromMap(result);
                if (StaticDBEnum.LOGIN.getValue().equals(dbType)) {//登录接口  只需要返回extra_info信息
                    if (userInfo != null) {
                        return userInfo;
                    } else {
                        throw new SenseFaceException("比中结果解析错误");
                    }
                } else if (StaticDBEnum.CHECK.getValue().equals(dbType)) {//核查接口 需要返回人员基本信息
                    if (userInfo != null) {
                         return getPersonInfoByIdentityId(userInfo.getKey());
                    } else {
                        throw new SenseFaceException("比中结果解析错误");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new SenseFaceException("比中结果解析错误");

            }

        }

        return null;
    }


    //从返回值中解析key（身份证号或者警号）
    public UserInfo getUserfromMap(Map<String, Object> map) {
        UserInfo userInfo = new UserInfo();
        if (map.containsKey("results")) {
            List<Map<String, Object>> maps = (List<Map<String, Object>>) map.get("results");
            Map<String, Object> map1 = maps.get(0);
            if (map1.containsKey("code")) {
                if (Integer.valueOf(map1.get("code").toString()) == 0) {
                    List<Map<String, Object>> maps1 = (List<Map<String, Object>>) map.get("search_results");
                    Map<String, Object> map2 = maps1.get(0);
                    if (map2.containsKey("similar_results")) {
                        List<Map<String, Object>> maps2 = (List<Map<String, Object>>) map2.get("similar_results");
                       if(maps2!=null&&maps2.size()>0){
                           Map<String, Object> map3 = maps2.get(0);
                           if (map3.containsKey("item")) {
                               Map<String, Object> map4 = (Map<String, Object>) map3.get("item");
                               String key = String.valueOf(map4.get("key"));
                               String extra_info = String.valueOf(map4.get("extra_info"));
                               userInfo.setKey(key);
                               userInfo.setExtraInfo(extra_info);
                               return userInfo;
                           }
                       }

                    }
                }
            }
        }
        return null;
    }


    //根据身份证号调用
    public UserInfo getPersonInfoByIdentityId(String identityId) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        String url = "/zxgk-sync/api/quick/gain/people?sfzh="+identityId;
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .build()
                .encode()
                .toUri();
        Map<String, Object> params = new HashMap<>();
        //params.put("identityId", identityId);

        //HttpHeaders headers = new HttpHeaders();
       // headers.set("contentType", "application/json");
        RequestEntity<SenseFaceImage> request =
                new RequestEntity(HttpMethod.GET, uri);

        //logger.info("getPersonInfoByIdentityId接口请求参数:{}", JSON.toJSONString(params));
        String value = restTemplate.exchange(request, String.class).getBody();
        logger.info("getPersonInfoByIdentityId接口返回值:{}", value);

        if (CheckEmptyUtil.isNotEmpty(value)) {
            try {
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                //UserInfo userInfo1=mapper.readValue(value, UserInfo.class);
                Map result = mapper.readValue(value, Map.class);
                if("1".equals(String.valueOf(result.get("code")))){
                    Map<String,Object> data=(Map)result.get("data");
                    UserInfo userInfo =new UserInfo();
                    userInfo.setKey(String.valueOf(data.get("id_number")));
                    userInfo.setId_number(String.valueOf(data.get("id_number")));
                    userInfo.setCertificate_image(String.valueOf(data.get("img")));
                    userInfo.setSex(String.valueOf(data.get("sex")));
                    userInfo.setBirthday(String.valueOf(data.get("birthday")));
                    userInfo.setNation(String.valueOf(data.get("nation")));
                    userInfo.setName(String.valueOf(data.get("name")));
                    userInfo.setAddress(String.valueOf(data.get("address")));
                    return userInfo;
                }else{
                    throw new SenseFaceException("人员信息查询接口查询失败");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
