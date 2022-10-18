package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author heyq
 * @create 2022-10-06-16:55
 */

@Controller
public class ViewController {

    @RequestMapping("/testThymeleafview")
    public String testThymeleafview(){
        return "success";
    }

    @RequestMapping("/testforward")
    public String testforward(){
        return "forward:/testThymeleafview";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafview";
    }
}
