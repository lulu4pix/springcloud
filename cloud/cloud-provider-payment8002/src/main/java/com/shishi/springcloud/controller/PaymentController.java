package com.shishi.springcloud.controller;

import com.shishi.springcloud.entities.CommonResult;
import com.shishi.springcloud.entities.Payment;
import com.shishi.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***插入结果：" + result);

        if(result > 0) {
            return new CommonResult(200,"insert success, server port: " + serverPort,result);
        } else {
            return new CommonResult(404, "insert failed", null);        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if(result != null) {
            return new CommonResult(200, "query success, server port: " + serverPort, result);
        } else {
            return new CommonResult(404, "query failed,query id is: "+ id, null);
        }
    }

}
