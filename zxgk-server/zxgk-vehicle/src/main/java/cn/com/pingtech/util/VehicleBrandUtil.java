package cn.com.pingtech.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PingTech
 * @desc
 * @create 2019-09-10 19:47
 **/
@Slf4j
public class VehicleBrandUtil {

    /**
     * 车辆主品牌
     */
    private static final Map<String, String> brandMap = new LinkedHashMap<>();

    /**
     * 车辆子品牌
     */
    private static final Map<String, String> subBrandMap = new LinkedHashMap<>();

    /**
     * 初始化车辆品牌
     * @throws Exception
     */
    public static void initBrand() throws Exception{
        ClassPathResource resource = new ClassPathResource("vehicleBrand.txt");
        if(!resource.exists()){
            return;
        }
        List<String> strList = null;
        try(InputStream inputStream = resource.getInputStream()){
            strList = IOUtils.readLines(inputStream,"UTF-8");
        }catch (Exception e){
            log.error("加载车辆品牌文件异常",e);
        }
        if(CollectionUtils.isEmpty(strList)){
            return;
        }

        log.info("加载车辆品牌文件成功, 共加载{}条数据", strList.size());

        for(String str : strList){
            if(StringUtils.isNotEmpty(str)){
                String[] strArr = str.split(",",-1);
                if(strArr.length == 4 && StringUtils.isNotEmpty(strArr[0]) && StringUtils.isNotEmpty(strArr[1])
                        && StringUtils.isNotEmpty(strArr[2]) && StringUtils.isNotEmpty(strArr[3])){
                    brandMap.put(strArr[0], strArr[1]);
                    subBrandMap.put(String.join("-",strArr[0], strArr[2]), strArr[3]);
                }
            }
        }
    }

    /**
     * 获取主品牌
     * @param value
     * @return
     */
    public static String getBrandTextByValue(String value){
        if(StringUtils.isNotEmpty(value)){
            if(brandMap.containsKey(value)){
                return brandMap.get(value);
            }
        }
        return "";
    }

    /**
     * 获取子品牌
     * @param brandValue
     * @param subBrandValue
     * @return
     */
    public static String getSubBrandTextByValue(String brandValue,String subBrandValue){
        if(StringUtils.isNotEmpty(brandValue) && StringUtils.isNotEmpty(subBrandValue)){
            String value = String.join("-", brandValue, subBrandValue);
            if(subBrandMap.containsKey(value)){
                return subBrandMap.get(value);
            }
        }
        return "";
    }

}

