package com.db.promote.param;

import com.db.promote.common.TagTypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author kun
 * @version 2019-01-06 15:16
 */
@Data
public class TagAddParam {

    @NotNull
    private TagTypeEnum tagType;

    @NotBlank
    private String tagName;

    @NotNull
    private Integer tagScore;

    private String remark;

}
