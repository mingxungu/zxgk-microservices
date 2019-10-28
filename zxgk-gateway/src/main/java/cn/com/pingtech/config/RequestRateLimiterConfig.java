package cn.com.pingtech.config;

import cn.com.pingtech.common.limit.UserLevelRedisRateLimiter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author gumx
 * @className: RequestRateLimiterConfig
 * @description: 限流控制器种类
 * @date 2019/10/18 16:14
 */
@Configuration
public class RequestRateLimiterConfig {

    @Bean
    @Primary
    KeyResolver apiKeyResolver() {
        //按URL限流
        return exchange -> Mono.just(exchange.getRequest().getPath().toString());
    }

    @Bean
    KeyResolver userKeyResolver() {
        //按用户限流
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    @Bean
    KeyResolver ipKeyResolver() {
        //按IP来限流
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    @Bean
    KeyResolver userLevelKeyResolver() {
        //按IP来限流
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("sys"));
    }

    @Bean
    @Primary
        //使用自己定义的限流类
    UserLevelRedisRateLimiter userLevelRedisRateLimiter(
            ReactiveRedisTemplate<String, String> redisTemplate,
            @Qualifier(UserLevelRedisRateLimiter.REDIS_SCRIPT_NAME) RedisScript<List<Long>> script,
            @Qualifier("defaultValidator") Validator validator){
        return new UserLevelRedisRateLimiter(redisTemplate , script , validator);
    }

}
