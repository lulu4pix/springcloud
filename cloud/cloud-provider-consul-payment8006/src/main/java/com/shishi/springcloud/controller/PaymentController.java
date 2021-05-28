package com.shishi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String bindPort;
    @RequestMapping("/payment/consul")
    private String PaymentConsul() {
        return "cloud for consul: " + bindPort + "\t" + UUID.randomUUID().toString();
    }
}
