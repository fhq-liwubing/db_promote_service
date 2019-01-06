package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Data
public class TaskCall implements Serializable {
    private Long id;

    private String taskNo;

    private String packageNo;

    private String companyNo;

    private Integer processStatus;

    private String contactPhoneList;

    private String lastContactPhone;

    private LocalDateTime lastContactTime;

    private Long lastContactHold;

    private LocalDateTime expectContactTime;

    private String resultTagNo;

    private String resultSubTagNo;

    private String scoreTagNo;

    private String processTagNo;

    private String contactLog;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}