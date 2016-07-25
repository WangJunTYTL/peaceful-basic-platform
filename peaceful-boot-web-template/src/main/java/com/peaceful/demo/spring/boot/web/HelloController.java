package com.peaceful.demo.spring.boot.web;

import com.alibaba.fastjson.JSON;
import com.peaceful.demo.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangJun
 * @version 1.0 16/6/4
 */
@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"", "/"})
    public String say(@RequestParam(defaultValue = "WJ") String msg) {
        return msg;
    }

    @RequestMapping("user")
    public String findUserById(@RequestParam(defaultValue = "0") long id) {
        return JSON.toJSONString(userService.findById(id));
    }


}
