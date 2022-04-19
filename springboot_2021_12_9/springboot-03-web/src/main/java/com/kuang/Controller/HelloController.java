package com.kuang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


//在templates 目录下的所有页面，只能通过controller来跳转
//这个需要模板引擎的支持 --> thymeleaf
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "test";
    }

    @RequestMapping("/test1")
    public String haha(Model model){
        model.addAttribute("msg","<h1>哇啦啦啦</h1>");

        model.addAttribute("users", Arrays.asList("jinx","wei"));
        return "test1";
    }

}
