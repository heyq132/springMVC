package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author heyq
 * @create 2022-10-05-11:25
 */
@Controller
//@RequestMapping("/test")
public class RequestMappingController {

    @RequestMapping(
            value = {"/testRequestMaping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = {"testParamsAndheaders"}, params = {"username", "password!=123456"}, headers = {"Host=localhost:8080"})
    public String testParamsAndheaders() {
        return "success";
    }
}
