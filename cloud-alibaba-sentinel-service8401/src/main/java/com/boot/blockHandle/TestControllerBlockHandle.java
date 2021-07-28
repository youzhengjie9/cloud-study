package com.boot.blockHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

@Component
public class TestControllerBlockHandle {

    //*******抽取出来的blockHandle方法必须要public static ，而且参数要有BlockException
    public static String testA_block(BlockException e){

        return "testA_block==="+e;
    }

    public static String testB_block(BlockException e){

        return "testB_block==="+e;
    }

    public static String testC_block(BlockException e){

        return "testC_block==="+e;
    }

}
