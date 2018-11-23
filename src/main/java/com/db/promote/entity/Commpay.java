package com.db.promote.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by lib on 2018/11/18.
 */
@Data
public class Commpay {

    private Integer id;

    private String compayName;

    private String phone;

    private String addr;

    private String business;

    private String accName;

    private Date createTime;

    private String type; //来源

    private String provinces; //省份

    private String city;//城市



}
