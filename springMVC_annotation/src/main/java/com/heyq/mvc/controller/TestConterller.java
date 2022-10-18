package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyq
 * @create 2022-10-11-16:21
 */
@Controller
public class TestConterller {

    @RequestMapping("/testExceptionHander")
    public String testExceptionHander(){
        System.out.println(1 / 0);
        return "success";
    }


}
