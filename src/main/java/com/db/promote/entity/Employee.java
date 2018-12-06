package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/06
*/
@Data
public class Employee {
    private Integer id;

    private String employeeNo;

    private String name;

    private String sex;

    private String phoneNo;

    private String email;

    private String province;

    private String city;

    private Integer status;

    private Date createTime;
}