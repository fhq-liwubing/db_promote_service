package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2019-01-06 15:22
 */
@Data
public class TagUpdateParam {

    @NotBlank
    private String tagNo;

    private String tagName;

    private Integer tagScore;

    private String remark;

    private Integer state;
}
