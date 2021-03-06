package com.shishi.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shishi.springcloud.handler.CustomizeHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @RequestMapping("/getResource")
    @SentinelResource(value = "getMySource", blockHandler = "handSentinel")
    public String  testHotKey() {
//        return new CommonResult(200, "success", new Payment(1L, "aaa"));
        return "success";
    }

    public String handSentinel(BlockException e) {
//        return new CommonResult(200, "success", new Payment(1L, "aaa"));
        return "fail";
    }

    @GetMapping("/global")
    @SentinelResource(value = "globals", blockHandlerClass = CustomizeHandler.class, blockHandler = "globalExceptionMethod")
    public String globalException() {
        return "global success";
    }
}
