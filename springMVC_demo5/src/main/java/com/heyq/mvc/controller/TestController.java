package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyq
 * @create 2022-10-10-15:35
 */
@Controller
public class TestController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
    @RequestMapping("/testExceptionHander")
    public String testExceptionHander(){
        System.out.println(1 / 0);
        return "success";
    }
}
