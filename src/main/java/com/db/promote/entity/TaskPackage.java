package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/06
*/
@Data
public class TaskPackage {
    private Integer id;

    private String taskPackageNo;

    private String taskPackageName;

    private Byte status;

    private Date completeTime;

    private Date createTime;

    private Date updateTime;
}