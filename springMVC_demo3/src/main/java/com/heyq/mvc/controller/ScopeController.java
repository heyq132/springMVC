package com.heyq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author heyq
 * @create 2022-10-06-14:12
 */

@Controller
public class ScopeController {

    //使用ServletAPI向request域对象共享数据
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope","hello ServletAPI");
        return "success";
    }

    //使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testMondelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("testScope","hello ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    //使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope","hello Model");
        return "success";
    }

    //使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testScope","hello Map");
        return "success";
    }

    //使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope","hello ModelMap");
        return "success";
    }

    //使用ServletAPI向session域共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "Hello Session");
        return "success";
    }

    //使用ServletAPI向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("testApplicationScope", "Hello Application");
        return "success";
    }
}
