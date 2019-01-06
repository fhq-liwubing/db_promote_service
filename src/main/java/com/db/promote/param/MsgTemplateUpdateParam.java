package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2019-01-06 15:59
 */
@Data
public class MsgTemplateUpdateParam {

    @NotBlank
    private String templateNo;

    private Integer templateType;

    private String templateName;

    private String content;

    private Integer state;

    private String remark;

}
