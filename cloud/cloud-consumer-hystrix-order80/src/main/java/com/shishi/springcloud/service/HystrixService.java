package com.shishi.springcloud.service;

import com.shishi.springcloud.service.impl.HystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = HystrixServiceImpl.class)
public interface HystrixService {
    @GetMapping("/payment/hystrix/ok")
    public String getPaymentInfoSuccess();
    @GetMapping("/payment/hystrix/timeout")
    public String getPaymentInfoTimeout();
}

