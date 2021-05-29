package com.shishi.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-service-url}")
    private String serviceUrl;


    @GetMapping("consumer/nacos/payment/{id}")
    public String getPaymentInfo(@PathVariable("id")Integer id) {
        return restTemplate.getForObject(serviceUrl + "/nacos/payment/"+id, String.class);
    }
}





