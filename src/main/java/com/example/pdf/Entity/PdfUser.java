package com.example.pdf.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* Copyright (C), 2018 - 2019, ZhengZho uChuangZhi. Co., Ltd
* FileName:
* 类的详细说明
*
* @author 张人杰
* @date   2019/12/5 21:48
* @version 1.0
*/
@Data
@Accessors(chain = true)
@TableName("user")
public class PdfUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value ="id", type = IdType.ID_WORKER)
    private Long id;

    private String name;

    private String phone;

    private Date creationTime;

}
