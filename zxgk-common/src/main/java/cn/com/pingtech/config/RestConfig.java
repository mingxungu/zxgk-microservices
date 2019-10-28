package cn.com.pingtech.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	
	@Bean
	public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory){
		return new RestTemplate(requestFactory);
	}
	
	@Bean
	public ClientHttpRequestFactory requestFactory(HttpClient httpClient){
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}
	
	@Bean
	public HttpClient httpClient(){
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", SSLConnectionSocketFactory.getSocketFactory())
				.build();
		
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
		connectionManager.setMaxTotal(1000);
		connectionManager.setDefaultMaxPerRoute(1000);
		connectionManager.setValidateAfterInactivity(2000);
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(2000)
				.setConnectTimeout(2000)
				.setSocketTimeout(15000)
				.build();
		
		return HttpClientBuilder.create()
				.setDefaultRequestConfig(requestConfig)
				.setConnectionManager(connectionManager)
				.build();
	}

}
