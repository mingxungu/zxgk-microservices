package cn.com.pingtech.service;

import com.alibaba.fastjson.JSON;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author PingTech
 * @desc
 * @create 2019-08-30 11:04
 **/
@Service
@Slf4j
public class ArtemisSerivce implements ApplicationRunner {

    /**
     * artemis网关服务器ip
     */
    @Value("${artemis.host}")
    private String host;
    /**
     * 秘钥appkey
     */
    @Value("${artemis.appKey}")
    private String appKey;
    /**
     * 秘钥appSecret
     */
    @Value("${artemis.appSecret}")
    private String appSecret;

    /**
     * 路径不用修改，就是/artemis
     */
    private static final String ARTEMIS_PATH = "/artemis";

    /**
     * 写入过车数据 URL
     */
    public static final String RECEIVE_MOTOR_VEHICLE_URL = ARTEMIS_PATH + "/api/bms/v2/receiveMotorVehicles";

    /**
     * 查询过车数据 URL
     */
    public static final String SEARCH_MOTOR_VEHICLES_URL = ARTEMIS_PATH + "/api/bms/v2/searchMotorVehicles";

    /**
     * 初始化artemis配置
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            log.info("初始化artemis配置,host:{},appKey:{},appSecret:{}",host,appKey,appSecret);

            ArtemisConfig.host = host;
            ArtemisConfig.appKey = appKey;
            ArtemisConfig.appSecret = appSecret;
        } catch (Exception e) {
            log.error("初始化artemis配置异常");
        }

    }

    /**
     * doPostJsonArtemis
     * @param path
     * @param body
     * @return
     */
    public String doPostJsonArtemis(Map<String, String> path, String body){
        String result = null;
        long start = System.currentTimeMillis();
        try {
            /*if(path.values().contains(ArtemisSerivce.RECEIVE_MOTOR_VEHICLE_URL)){
                result = FileUtils.readFileToString(new File("D:/opt/zxgk-vehicle/receive.txt"),"UTF-8");
            }else{
                result = FileUtils.readFileToString(new File("D:/opt/zxgk-vehicle/search.txt"),"UTF-8");
            }*/
            result = ArtemisHttpUtil.doPostStringArtemis(path,body,null,null,"application/json");
        } catch (Exception e) {
            log.error("海康接口调用异常, 请求地址: {}",JSON.toJSONString(path), e);
        }
        long end = System.currentTimeMillis();
        log.info("海康接口调用, 耗时: {}ms, 请求地址: {},请求参数: {},返回结果: {}", (end - start), JSON.toJSONString(path), body, result);
        return result;
    }
}

