package com.shishi.alibaba.service;

import com.shishi.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value="PAYMENT-PROVIDER")
public interface OrderService {
    @GetMapping(value="/consumer/get/{id}")
    public CommonResult getPaymentById(String id);
}




