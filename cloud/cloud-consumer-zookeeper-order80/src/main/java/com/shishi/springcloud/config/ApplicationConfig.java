package com.shishi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced //这个注解如果没有则会报错：I/O error on GET request for "http://cloud-provider-payment/payment/zk": cloud-provider-payment; nes
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
