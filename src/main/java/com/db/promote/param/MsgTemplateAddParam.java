package com.db.promote.param;

import lombok.Data;

/**
 * @author kun
 * @version 2019-01-06 16:00
 */
@Data
public class MsgTemplateAddParam {

    private Integer templateType;

    private String templateName;

    private String content;

    private String remark;

}
