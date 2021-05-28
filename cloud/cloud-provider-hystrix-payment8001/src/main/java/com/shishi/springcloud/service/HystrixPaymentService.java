package com.shishi.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class HystrixPaymentService {
    public String getPaymentInfoSuccess() {
        return "thread poor: " + Thread.currentThread().getName() + " success";
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String getPaymentInfoTimeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread poor: " + Thread.currentThread().getName() + " timeout";
    }

    public String timeoutHandler() {
        return "call back fail";
    }


    /**
     *
     *模拟服务熔断
     * 这里的意思是： 在10秒的时间窗口期内，请求次数超过十次，失败率达到30%,就打开服务熔断
     */
    @HystrixCommand(fallbackMethod = "circuitBreakerCallbackMethod", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),   // 打开服务熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),  //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="30")  // 失败达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "调用成功，流水号为： " + serialNumber;
    }

    public String circuitBreakerCallbackMethod(@PathVariable("id") Integer id) {
        return "id不能为负数，启动了服务熔断..." + id;
    }
}
