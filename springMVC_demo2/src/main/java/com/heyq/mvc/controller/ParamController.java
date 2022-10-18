package com.heyq.mvc.controller;

import com.heyq.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author heyq
 * @create 2022-10-05-15:47
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";

    }

    @RequestMapping("/testparam")
    public String testparam(
            @RequestParam(value = "user_name",required = false ,defaultValue = "admin") String username,
            String password,
            String[] hobby,
            @RequestHeader("Host") String host,
            @CookieValue("JSESSIONID") String JSESSIONID){
        System.out.println("username:" + username + ",password:" + password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testpojo(User user){
        System.out.println(user);
        return "success";
    }

}
