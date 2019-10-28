package cn.com.pingtech.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author gumx
 * @className: AuthorizeGatewayFilter
 * @description: Token权限认证拦截服务
 * @date 2019/9/3 10:31
 */
@Component
public class AuthorizeGatewayFilter implements GatewayFilter, Ordered {

    private static final String AUTHORIZE_TOKEN = "token";
    private static final String AUTHORIZE_UID = "uid";

/*    @Autowired
    private StringRedisTemplate stringRedisTemplate;*/

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /*ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AUTHORIZE_TOKEN);
        String uid = headers.getFirst(AUTHORIZE_UID);
        if (token == null) {
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        if (uid == null) {
            uid = request.getQueryParams().getFirst(AUTHORIZE_UID);
        }

        ServerHttpResponse response = exchange.getResponse();

        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
*//*        String authToken = stringRedisTemplate.opsForValue().get(uid);
        if (authToken == null || !authToken.equals(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }*/

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
