package com.shishi.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/payment/{id}")
    public String getPaymentInfo(@PathVariable("id")Integer id) {
        return "nacos discovery port: " + port + "\tpayment info is:" + id;
    }
}
