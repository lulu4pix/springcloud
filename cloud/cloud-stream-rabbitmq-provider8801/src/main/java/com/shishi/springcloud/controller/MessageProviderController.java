package com.shishi.springcloud.controller;

import com.shishi.springcloud.service.MessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageProviderController {
    @Resource
    MessageProvider providerService;
    @GetMapping(value = "/send")
    public String sendMessage() {
        return providerService.sendMessage();
    }
}
