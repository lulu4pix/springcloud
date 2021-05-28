package com.shishi.springcloud.controller;

import com.shishi.springcloud.entities.CommonResult;
import com.shishi.springcloud.entities.Payment;
import com.shishi.springcloud.service.PaymentFeignService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentOpenFeignTimeOut() {
        return paymentFeignService.paymentOpenFeignTimeOut();
    }
}
