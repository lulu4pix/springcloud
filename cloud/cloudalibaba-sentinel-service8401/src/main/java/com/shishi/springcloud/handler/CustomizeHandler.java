package com.shishi.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;

public class CustomizeHandler {
    public static String globalExceptionMethod(BlockException e) {
        return "global exception handler method...";
    }
}
