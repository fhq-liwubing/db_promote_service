package com.db.promote.param;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2019-01-06 17:40
 */
@Data
public class FileQueryParam {

    private Integer fileType;

    private String fileName;

    private Integer share;

    private String remark;

    private Integer state;

    private LocalDateTime createTimeFrom;

    private LocalDateTime createTimeTo;

}
