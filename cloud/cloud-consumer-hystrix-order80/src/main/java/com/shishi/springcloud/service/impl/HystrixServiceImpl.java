package com.shishi.springcloud.service.impl;

import com.shishi.springcloud.service.HystrixService;
import org.springframework.stereotype.Service;

@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String getPaymentInfoSuccess() {
        return "HystrixServiceImpl ok fallback  ... ";
    }

    @Override
    public String getPaymentInfoTimeout() {
        return "HystrixServiceImpl timeout fallback ... ";
    }
}
