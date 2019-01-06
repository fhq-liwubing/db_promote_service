package com.db.promote.vo;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 11:10
 */
@Data
public class PackageVO {

    private String packageNo;

    private String packageName;

    private Integer taskType;

    private String terminal;

    private Integer processStatus;

    private String finishTime;

    private String remark;

    private String createTime;

    private String updateTime;

}
