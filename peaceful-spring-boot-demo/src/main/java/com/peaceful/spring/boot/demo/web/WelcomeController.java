package com.peaceful.spring.boot.demo.web;

import com.peaceful.spring.boot.demo.utils.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @RequestMapping("/")
    public String test01(){
        return "hello world";
    }

    @RequestMapping("/vm")
    public String test02(String name){
        Map<String,Object> data = new HashMap<>();
        if (StringUtils.isNotBlank(name)){
            data.put("name",name);
        }
        return PageResult.render("static/index.vm",data);
    }
}
