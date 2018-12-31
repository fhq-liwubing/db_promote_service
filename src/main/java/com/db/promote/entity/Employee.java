package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/27
*/
@Data
public class Employee implements Serializable {

    private Long id;

    private String employeeNo;

    private String username;

    private String selfPhone;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

    private List<Terminal> terminals;
}