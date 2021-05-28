package com.shishi.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shishi.springcloud.service.HystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalFallBackMethod")
public class HystrixController {
    @Resource
    private HystrixService hystrixService;

    @GetMapping("/consumer/payment/hystrix/ok")
    public String getPaymentInfoSuccess() {
        return hystrixService.getPaymentInfoSuccess();
    }

    @GetMapping("/consumer/payment/hystrix/timeout")
    @HystrixCommand
    public String getPaymentInfoFail() {
        return hystrixService.getPaymentInfoTimeout();
    }

    public String orderTimeoutHandler() {
        return "order timeout handler...";
    }

    public String globalFallBackMethod() {
        return "global fallback handler...";
    }
}
