package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Data
public class TaskPackage implements Serializable {
    private Long id;

    private String packageNo;

    private String packageName;

    private Integer taskType;

    private String terminal;

    private Integer processStatus;

    private LocalDateTime finishTime;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}