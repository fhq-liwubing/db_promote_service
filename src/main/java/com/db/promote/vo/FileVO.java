package com.db.promote.vo;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 17:48
 */
@Data
public class FileVO {

    private String fileNo;

    private Integer fileType;

    private String fileName;

    private String filePath;

    private String belongTerminal;

    private Integer share;

    private Integer state;

    private String remark;

    private String createTime;

    private String updateTime;

}
