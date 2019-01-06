package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Data
public class Tag implements Serializable {
    private Long id;

    private Integer tagType;

    private String tagNo;

    private String parTagNo;

    private String tagName;

    private Integer tagScore;

    private Integer meta;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}