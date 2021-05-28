package com.shishi.springcloud.controller;


import com.shishi.springcloud.entities.CommonResult;
import com.shishi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
//    单机版本
//    private static final String PAYMENT_URL = "http://localhost:8001";

    // 集群版本
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @PostMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("***cumsumer create start***");
        return restTemplate.postForObject(PAYMENT_URL +"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("***cumsumer query start***");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
