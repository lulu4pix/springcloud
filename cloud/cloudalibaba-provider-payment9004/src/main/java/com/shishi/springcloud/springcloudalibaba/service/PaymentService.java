package com.shishi.springcloud.springcloudalibaba.service;

import com.shishi.springcloud.entities.CommonResult;
import com.shishi.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentService {

    // mock database
    private static Map<String, Payment> payments = new HashMap<String, Payment>();
    static {
        payments.put("1", new Payment(1L, "payment1"));
        payments.put("2", new Payment(2L, "payment2"));
        payments.put("3", new Payment(3L, "payment3"));
    }

    public CommonResult getPaymentById(String id) {
        Payment payment = payments.get(id);
        return new CommonResult(200, "success", payment);
    }
}
