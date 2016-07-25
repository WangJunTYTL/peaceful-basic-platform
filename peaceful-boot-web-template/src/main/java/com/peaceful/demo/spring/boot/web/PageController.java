package com.peaceful.demo.spring.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WangJun
 * @version 1.0 16/6/4
 */
@Controller
public class PageController {


    @RequestMapping("jsp01")
    public String jsp(@RequestParam(defaultValue = "WJ") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("page->" + name);
        return "index";
    }

    @RequestMapping("jsp02")
    public String jsp02(@RequestParam(defaultValue = "WJ") String name, Model model) {
        model.addAttribute("name", name);
        System.out.println("page->" + name);
        return "template02";
    }

}
