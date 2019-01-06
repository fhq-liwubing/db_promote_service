package com.db.promote.param;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 18:32
 */
@Data
public class FileUploadParam {

    private String fileName;

    private Integer fileType;

    private Integer share;

    private String terminalNo;

    private String remark;

}
