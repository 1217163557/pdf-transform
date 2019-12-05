package com.example.pdf.controller;


import com.example.pdf.entity.PdfUser;
import com.example.pdf.service.PdfUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
* Copyright (C), 2018 - 2019, ZhengZho uChuangZhi. Co., Ltd
* FileName:
* 类的详细说明
*
* @author 张人杰
* @date   2019/12/5 21:59
* @version 1.0
*/
@Api(value = "pdfUser")
@Controller
@RequestMapping("/pdfUser")
public class PdfUserController {
    @Autowired
    private PdfUserService pdfUserService;
    @ApiOperation("add")
    @GetMapping("add")
    @ResponseBody
    public void add(){
        PdfUser user=new PdfUser();
        user.setName("zhangsan")
            .setPhone("13283860845")
            .setCreationTime(new Date());
        System.out.println(new Date());
        boolean insert = pdfUserService.insert(user);
    }
}

