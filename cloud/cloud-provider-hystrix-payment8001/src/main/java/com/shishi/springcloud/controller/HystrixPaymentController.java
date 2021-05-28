package com.shishi.springcloud.controller;

import com.shishi.springcloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class HystrixPaymentController {
    @Resource
    HystrixPaymentService service;

    @GetMapping("/payment/hystrix/ok")
    public String getPaymentInfoSuccess() {
        return service.getPaymentInfoSuccess();
    }

    @GetMapping("/payment/hystrix/timeout")
    public String getPaymentInfoTimeout() {
        return service.getPaymentInfoTimeout();
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return service.paymentCircuitBreaker(id);
    }
}
