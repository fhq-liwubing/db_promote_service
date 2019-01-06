package com.db.promote.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/01/06
*/
@Data
public class File implements Serializable {
    private Long id;

    private String fileNo;

    private Integer fileType;

    private String fileName;

    private String filePath;

    private String belongTerminal = "0";

    private Integer share;

    private Integer state;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}