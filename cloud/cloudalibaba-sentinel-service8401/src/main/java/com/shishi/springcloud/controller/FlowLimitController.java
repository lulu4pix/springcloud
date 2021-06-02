package com.shishi.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/getA")
    public String getA() {
        return "testA...";
    }

    @GetMapping("/getB")
    public String getB() {
        System.out.println(Thread.currentThread().getName() + ".../getB");
        return "testB...";
    }

    @GetMapping("/testD")
    public String testD() {
        int i = 10/0;
        return "testD...";
    }
}
