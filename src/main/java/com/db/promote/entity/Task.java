package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Data
public class Task {

    private Integer id;

    private String taskNo;

    private String companyNo;

    private String taskPackageNo;

    private String staus;

    private Integer progress;

    private String tag;

    private String completeTime;

    private Date createTime;

    private Date updateTime;
}