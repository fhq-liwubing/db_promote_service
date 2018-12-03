package com.db.promote.entity;

import com.db.promote.common.SourceTypeEnum;
import lombok.Data;

import java.util.Date;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Data
public class CompanyOrigin {
    private Integer id;

    private String compayName;

    private String phone;

    private String addr;

    private String business;

    private String accName;

    private SourceTypeEnum sourceType; //来源

    private String provinces; //省份

    private String city;//城市

    private Date createTime;

    private Date updateTime;

    private String mail; //邮箱地址


}