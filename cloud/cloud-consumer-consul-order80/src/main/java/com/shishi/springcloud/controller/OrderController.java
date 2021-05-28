package com.shishi.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    private static final String URL = "http://consul-provider-payment";

    @RequestMapping(value="/consumer/consul")
    public String getPaymentConsul() {
        String result = restTemplate.getForObject(URL + "/payment/consul", String.class);
        return result;
    }
}
