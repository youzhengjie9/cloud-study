package com.boot.feign.impl;

import com.boot.feign.TestFeign;
import org.springframework.stereotype.Service;

@Service
public class TestFeignImpl implements TestFeign {


    @Override
    public String sentinelFeign() {
        return "sentinelFeign=====TestFeignImpl";
    }
}
