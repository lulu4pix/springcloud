package com.shishi.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shishi.springcloud.entities.CommonResult;
import com.shishi.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.constraints.Null;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${payment.service}")
    private String paymentServiceName;

    @GetMapping(value="/consumer/get/{id}")
    @SentinelResource(value = "fallback", fallback = "fallBackMethod")  // 只负责业务异常
    public CommonResult getPaymentById(@PathVariable(value = "id", required = true) String id) {
        CommonResult result = restTemplate.getForObject(paymentServiceName + "/payment/" + id, CommonResult.class);
        // mock fall back
        if ("4".equals(id)) {
            throw new IllegalArgumentException("非法参数异常， 参数是：" + id);
        } else if (result.getData() == null) {
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    // fallback
    public CommonResult fallBackMethod(@PathVariable(value = "id", required = true) String id, Throwable e) {  //这个throwable不是必须的，只是为了抛出异常信息用
        Payment payment = new Payment(Long.parseLong(id), null);
        return new CommonResult(444, "error message is : " + e.getMessage(), payment);
    }
}
