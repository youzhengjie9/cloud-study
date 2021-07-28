package com.boot.handle;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//public class SentinelExceptionHandle implements BlockExceptionHandler {
//    @Override
//    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException ex) throws Exception {
//
//        String msg = null;
//        if (ex instanceof FlowException) {
//            msg = "被Sentinel限流了";
//        } else if (ex instanceof DegradeException) {
//            msg = "被Sentinel降级了";
//        } else if (ex instanceof ParamFlowException) {
//            msg = "被Sentinel热点参数限流";
//        } else if (ex instanceof SystemBlockException) {
//            msg = "被Sentinel系统规则（负载/...不满足要求）";
//        } else if (ex instanceof AuthorityException) {
//            msg = "被Sentinel授权规则不通过";
//        }
//       httpServletRequest.getRequestDispatcher("")
//
//    }
//}
