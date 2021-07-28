package com.boot.feign;

import com.boot.feign.impl.TestFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "sentinel-service",fallback = TestFeignImpl.class)
public interface TestFeign {

    @ResponseBody
    @RequestMapping(path = "/provider/sentinelFeign")  //注意：二级路径别看错了。。。。。。。。。。。
    public String sentinelFeign();



}
