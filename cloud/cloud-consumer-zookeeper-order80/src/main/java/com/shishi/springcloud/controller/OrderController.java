package com.shishi.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    private static final String url = "http://cloud-provider-payment";

    @GetMapping(value="/consumer/payment/zk")
    public String getPaymentInfo() {
        String result = restTemplate.getForObject(url + "/payment/zk", String.class);
        return result;
    }
}
