package com.heyq.mvc.controller;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author heyq
 * @create 2022-10-10-21:03
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String handerException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
