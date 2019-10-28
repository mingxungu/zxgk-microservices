package cn.com.pingtech.controller;

import cn.com.pingtech.constant.Constants;
import cn.com.pingtech.service.ArtemisSerivce;
import cn.com.pingtech.util.VehicleBrandUtil;
import cn.com.pingtech.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author PingTech
 * @desc 车辆数据接口
 * @create 2019-08-30 10:24
 **/
@RestController
@RequestMapping(value="/api/vehicle")
@Slf4j
public class VehicleController {

    @Autowired
    private ArtemisSerivce artemisSerivce;

    @Value("${vehicleData.crossingId}")
    private String crossingId;

    @Value("${vehicleData.recognizeTime}")
    private int recognizeTime;

    /**
     * 写入过车数据
     * @return
     */
    @RequestMapping(value = "/receiveMotorVehicles")
    public String receiveMotorVehicles(@RequestBody String body){
        Map<String, String> path = new HashMap<String, String>();
        path.put("https://", ArtemisSerivce.RECEIVE_MOTOR_VEHICLE_URL);
        return artemisSerivce.doPostJsonArtemis(path, body);
    }

    /**
     * 查询过车数据
     * @return
     */
    @RequestMapping(value = "/searchMotorVehicles")
    public String searchMotorVehicles(@RequestBody String body){
        Map<String, String> path = new HashMap<String, String>();
        path.put("https://", ArtemisSerivce.SEARCH_MOTOR_VEHICLES_URL);
        return artemisSerivce.doPostJsonArtemis(path, body);
    }

    /**
     * 车辆照片识别
     * @param body
     * @return
     */
    @RequestMapping(value = "/pictureRecognition")
    public ResultVo<Object> pictureRecognition(@RequestBody ReceiveVehicleVo body){
        try {
            if(body == null){
                return ResultVo.fail();
            }
            if(StringUtils.isEmpty(body.getVehiclepicurl())){
                return ResultVo.fail("车辆照片为空");
            }

            Date passTime = new Date();

            //写入过车数据
            body.setCrossing_id(crossingId);
            body.setPlate_no(Constants.UNKNOWN_PLATE);
            body.setPass_time(DateFormatUtils.format(passTime,"yyyy-MM-dd HH:mm:ss.SSS"));
            List<ReceiveVehicleVo> receiveBody = new ArrayList<>();
            receiveBody.add(body);
            Map<String, String> receivePath = new HashMap<String, String>();
            receivePath.put("https://", ArtemisSerivce.RECEIVE_MOTOR_VEHICLE_URL);
            String receiveResult = artemisSerivce.doPostJsonArtemis(receivePath, JSON.toJSONString(receiveBody));
            if(StringUtils.isEmpty(receiveResult)){
                return ResultVo.fail();
            }
            ResultVo<Object> resultVo = JSON.parseObject(receiveResult,ResultVo.class);
            if(resultVo == null || !ResultVo.SUCCESS.equals(resultVo.getCode())){
                return ResultVo.fail();
            }

            //上传过车数据完成之后，需要等待一段时间，才能获取到车辆照片识别之后的结果
            if(recognizeTime > 0){
                TimeUnit.MILLISECONDS.sleep(recognizeTime);
            }

            //查询过车数据
            SearchVehicleVo searchVehicleBody = new SearchVehicleVo();
            searchVehicleBody.setPageNo(1);
            searchVehicleBody.setPageSize(200);
            searchVehicleBody.setCrossingIds(crossingId);
            searchVehicleBody.setStartTime(DateFormatUtils.format(passTime,"yyyy-MM-dd HH:mm:ss"));
            searchVehicleBody.setEndTime(DateFormatUtils.format(DateUtils.addSeconds(passTime,1),"yyyy-MM-dd HH:mm:ss"));

            Map<String, String> searchPath = new HashMap<String, String>();
            searchPath.put("https://", ArtemisSerivce.SEARCH_MOTOR_VEHICLES_URL);
            String searchResult = artemisSerivce.doPostJsonArtemis(searchPath, JSON.toJSONString(searchVehicleBody));
            if(StringUtils.isEmpty(searchResult)){
                return ResultVo.fail();
            }

            ResultVo<PageVo<PassVehicleVo>> searchResultVo = JSON.parseObject(searchResult,new TypeReference<ResultVo<PageVo<PassVehicleVo>>>(){});
            if(searchResultVo == null || !ResultVo.SUCCESS.equals(searchResultVo.getCode())){
                return ResultVo.fail();
            }

            List<PassVehicleVo> dataList = new ArrayList<>();
            PageVo<PassVehicleVo> pageVo = searchResultVo.getData();
            int pageCount = 0;
            int pageSize = searchVehicleBody.getPageSize();
            if(pageVo != null){
                pageCount = (pageVo.getTotal() + pageSize - 1) / pageSize;
                if(!CollectionUtils.isEmpty(pageVo.getList())){
                    dataList.addAll(pageVo.getList());
                }
            }

            //分页查询
            if(pageCount > 1){
                for(int i = 2; i <= pageCount; i++){
                    searchVehicleBody.setPageNo(i);
                    searchResult = artemisSerivce.doPostJsonArtemis(searchPath, JSON.toJSONString(searchVehicleBody));
                    if(StringUtils.isEmpty(searchResult)){
                        return ResultVo.fail();
                    }
                    searchResultVo = JSON.parseObject(searchResult,new TypeReference<ResultVo<PageVo<PassVehicleVo>>>(){});
                    if(searchResultVo == null || !ResultVo.SUCCESS.equals(searchResultVo.getCode())){
                        return ResultVo.fail();
                    }
                    pageVo = searchResultVo.getData();
                    if(pageVo != null && !CollectionUtils.isEmpty(pageVo.getList())){
                        dataList.addAll(pageVo.getList());
                    }
                }
            }

            //数据转换
            PassVehicleVo passVehicleVo = null;
            if(!CollectionUtils.isEmpty(dataList)){
                List<PassVehicleVo> tempList = dataList.stream()
                        .filter(passVehicle -> body.getVehiclepicurl().equals(passVehicle.getPicAbbreviate())  && !Constants.UNKNOWN_PLATE.equals(passVehicle.getPlateInfo()))
                        .collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(tempList)){
                    passVehicleVo = tempList.get(0);
                    passVehicleVo.setPlateColor(Constants.PlateColor.getTextByValue(passVehicleVo.getPlateColor()));
                    passVehicleVo.setPlateType(Constants.PlateType.getTextByValue(passVehicleVo.getPlateType()));
                    passVehicleVo.setVehicleColor(Constants.VehicleColor.getTextByValue(passVehicleVo.getVehicleColor()));
                    passVehicleVo.setVehicleHead(Constants.VehicleHeadDirection.getTextByValue(passVehicleVo.getVehicleHead()));
                    passVehicleVo.setVehicleType(Constants.VehicleType.getTextByValue(passVehicleVo.getVehicleType()));
                    String brandValue = passVehicleVo.getAutoBrand();
                    String subBrandValue = passVehicleVo.getVehicleSublogo();
                    passVehicleVo.setAutoBrand(VehicleBrandUtil.getBrandTextByValue(brandValue));
                    passVehicleVo.setVehicleSublogo(VehicleBrandUtil.getSubBrandTextByValue(brandValue, subBrandValue));
                }
            }
            return ResultVo.success(passVehicleVo);
        } catch (Exception e) {
            log.error("车辆照片识别异常",e);
        }
        return ResultVo.fail();
    }
}

