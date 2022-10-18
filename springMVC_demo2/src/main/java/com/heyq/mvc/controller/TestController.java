package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyq
 * @create 2022-10-05-9:48
 */

@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
//
//    @RequestMapping("/param")
//    public String param(){
//        return "test_param";
//    }
    @RequestMapping("/")
    public String index() {
        return "test_param";
    }
}
