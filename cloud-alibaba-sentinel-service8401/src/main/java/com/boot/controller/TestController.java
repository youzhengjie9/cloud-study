package com.boot.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.boot.blockHandle.TestControllerBlockHandle;
import com.boot.fallback.TestControllerFallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/test")
public class TestController {

    private static int count=0;

    /**
     * 测试Sentinel监控8401模块
     *
     * 使用url来流控和@SentinelResource流控区别：
     * =============================
     * 使用url:使用url不能进行自定义兜底方法，所以sentinel默认会给url提供一个响应结果：Blocked by Sentinel (flow limiting)
     *
     * 使用@SentinelResourc：可以进行自定义blockHandle，但是如果没有写blockHandle的话，不会输出上面的结果，而是报错500。。。。
     *
     */
    @ResponseBody
    @RequestMapping(path = "/testA")
    @SentinelResource(value = "test-testA",blockHandlerClass = TestControllerBlockHandle.class,
                      blockHandler = "testA_block") //定义sentinel资源，最好使用这个注解去配合sentinel，而不是使用上面的requestMapping
    //因为RequestMapping不能自定义降级方法，而SentinelResource可以自定义降级方法，灵活性更高
    public String testA(){
        return "testA";
    }

    @ResponseBody
    @RequestMapping(path = "/testB")
    @SentinelResource("test-testB")
    public String testB(){

        return "testB";
    }

    @ResponseBody
    @RequestMapping(path = "/testC")
    @SentinelResource(value = "test-testC",blockHandlerClass = TestControllerBlockHandle.class,
            blockHandler = "testC_block")
    public String testC(){

        int i=10/0; //异常


        return "testC";
    }


    @ResponseBody
    @RequestMapping(path = "/testD")
    @SentinelResource(value = "test-testD")
    public String testD(@RequestParam(value = "p1",required = false) String p1,
                        @RequestParam(value = "p2",required = false) String p2){


        return "testC";
    }

    /**
     * fallback和blockHandle区别
     * =======================
     * fallback：当Java代码报异常时则会检测到并且进行fallback兜底方法，如果没有指定fallback，报了Java异常，则会直接显示不友好页面（报错）
     * blockHandle：只对Sentinel控制台设置的条件（比如qps达到多少阈值就限流或者达到多少异常比例就降级），然后会进入blockHandle方法
     * ，如果没有blockHandle方法的话，就会使用Sentinel默认的，另外blockHandle抽取到其他类中（解耦），对blockHandle方法有一定的要求，
     * 比如：必须是public static 和参数必须要有BlockException类型
     *
     * ============================
     *
     * 建议：推荐使用Sentinel进行保护的时候尽量把fallback和blockHandle都写上。。。。。。。。。。。。。。。。。。。。。。。
     * 这样既可以防止报异常导致不友好页面展示给用户，也可以防止服务被降级和限流展示不友好页面
     */


    @ResponseBody
    @RequestMapping(path = "/testE")
    @SentinelResource(value = "test-testE",fallbackClass = TestControllerFallback.class,fallback = "testE_fallback")
    public String testE(){
        count++;
        if(count==3){
            throw new RuntimeException("异常了");
        }

        return "testE"+count;
    }



}
