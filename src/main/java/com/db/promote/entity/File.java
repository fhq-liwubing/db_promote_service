package com.db.promote.entity;

import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/02
 * @author kun
 */
@Data
public class File {

    private Integer id;

    private String fileNo;

    private String fileName;

    private String filePath;

    private String terminalNo;

    private Integer share;

    private Date createTime;

    private Date updateTime;
}