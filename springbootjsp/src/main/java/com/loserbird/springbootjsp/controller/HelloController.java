package com.loserbird.springbootjsp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author: bingqin
 * @Date: 2018/1/26
 * @Description:
 **/
@Controller
public class HelloController {

    // 从 application.properties 中读取配置，如取不到默认值为Hello bingqin
    @Value("${application.hello:Hello bingqin}")
    private String hello;


    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String,Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello", hello);
        return "helloJsp";
    }
}
