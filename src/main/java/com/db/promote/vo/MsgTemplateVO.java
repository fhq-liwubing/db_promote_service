package com.db.promote.vo;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 15:53
 */
@Data
public class MsgTemplateVO {

    private String templateNo;

    private String templateName;

    private Integer templateType;

    private String content;

    private String remark;

    private String createTime;

    private String updateTime;

}
