package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/02
*/
@Data
public class TaskPackage {
    private Integer id;

    private String taskPackageName;

    private Integer status;

    private Date completeTime;

    private Date createTime;

    private Date updateTime;

    private byte[] taskPackageNo;
}