package com.shishi.springcloud.springcloudalibaba.controller;

import com.shishi.springcloud.entities.CommonResult;
import com.shishi.springcloud.springcloudalibaba.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id) {
        return paymentService.getPaymentById(id);
    }
}
