package com.veeru.test.springboot3democlient.config;

import com.veeru.test.springboot3democlient.service.EmployeeClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.net.http.HttpClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient employeeServiceWebClient() {
        return WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @Bean
    public EmployeeClientService employeeClientService() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(WebClientAdapter.create(employeeServiceWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(EmployeeClientService.class);
    }


}
