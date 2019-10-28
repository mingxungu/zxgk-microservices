package cn.com.pingtech.config;

/**
 * @author gumx
 * @className: UserLevelRateLimiterConf
 * @description: 限流配置文件
 * @date 2019/10/18 16:12
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//使用配置文件的方式进行初始化

@Component
@ConfigurationProperties(prefix = "comsumer.ratelimiter-conf")
public class UserLevelRateLimiterConf {
    //处理速度
    private static final String DEFAULT_REPLENISHRATE="default.replenishRate";
    //容量
    private static final String DEFAULT_BURSTCAPACITY="default.burstCapacity";

    //默认配置
    private Map<String , Integer> rateLimitMap = new ConcurrentHashMap<String , Integer>(){
        {
            put(DEFAULT_REPLENISHRATE , 10);
            put(DEFAULT_BURSTCAPACITY , 100);
        }
    };

    public Map<String, Integer> getRateLimitMap() {
        return rateLimitMap;
    }

    public void setRateLimitMap(Map<String, Integer> rateLimitMap) {
        this.rateLimitMap = rateLimitMap;
    }
}
