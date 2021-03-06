package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Data
public class MsgTemplate implements Serializable {
    private Integer id;

    private String templateNo;

    private String templateName;

    private Integer templateType;

    private String content;

    private Integer paramSize;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}