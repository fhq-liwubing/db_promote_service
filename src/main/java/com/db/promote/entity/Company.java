package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/08
*/
@Data
public class Company {
    private Integer id;

    private String companyNo;

    /* 公司名称*/
    private String companyName;

    /* 手机号*/
    private String phone;

    /* 省份*/
    private String provinces     ;

    /* 城市*/
    private String city;

    /* 公司地址*/
    private String addr;

    /* 联系人姓名*/
    private String accName;

    /* 经营范围*/
    private String business;

    /* 来源：*/
    private String sourceType;

    /* 邮箱地址*/
    private String mail;

    private Date createTime;
}