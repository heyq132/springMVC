package com.heyq.mvc.controller;

import com.heyq.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author heyq
 * @create 2022-10-09-10:28
 */
@Controller
public class httpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestbody){
        System.out.println("requestbody:"+requestbody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("请求头："+requestEntity.getHeaders());
        System.out.println("请求体："+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,response");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"admin","123456",20,"男");
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }
}
