package com.example.pdf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Copyright (C), 2018 - 2019, ZhengZhouChuangZhi. Co., Ltd.
 * FileName: [ 文件名 ]
 * 类的详细说明
 *
 * @author 张人杰
 * @version 1.0
 * @Date 2020/1/5 21:58
 */


@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    private static int online=0;
    @RequestMapping("/3")
    public String hello(Map<String, Object> map) {
        online++;
        map.put("username", "fanfan"+online);
        return "3.html";
    }
    @RequestMapping("/hello")
    public String hello3(Map<String, Object> map) {
        map.put("name", "fanfan");
        return "hello.html";
    }


}
