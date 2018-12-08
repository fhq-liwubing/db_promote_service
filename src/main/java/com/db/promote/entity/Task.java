package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/08
*/
@Data
public class Task {
    private Integer id;

    private String taskNo;

    private String companyNo;

    private String taskPackageNo;

    private String status;

    private Integer progress;

    private String mark;

    private String remark;

    private Date completeTime;

    private Date createTime;

    private Date updateTime;
}