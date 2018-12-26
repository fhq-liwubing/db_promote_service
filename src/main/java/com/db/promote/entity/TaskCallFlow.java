package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/26
*/
@Data
public class TaskCallFlow implements Serializable {
    private Long id;

    private String selfPhone;

    private String taskFrom;

    private String terminalFrom;

    private String contactPhone;

    private LocalDateTime contactTime;

    private Long contactHold;

    private Integer processStatus;

    private String resultTagNo;

    private String processTagNo;

    private String contactLog;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}