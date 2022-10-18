package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyq
 * @create 2022-10-06-14:06
 */

@Controller
public class TestController {

    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/

    @RequestMapping("/test_view")
    public String test_view(){
        return "test_view";
    }
}
