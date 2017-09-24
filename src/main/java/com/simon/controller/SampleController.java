package com.simon.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by xiaotao on 2017/5/16.
 */
@Controller
public class SampleController {

    @RequestMapping("/index")
    public void index(Model model) {
        System.out.println("index-test-controller");
//        return "index";
    }

}