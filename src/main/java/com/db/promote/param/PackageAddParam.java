package com.db.promote.param;

import com.db.promote.util.constants.TaskTypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author kun
 * @version 2019-01-06 11:09
 */
@Data
public class PackageAddParam {

    @NotBlank
    private String packName;

    @NotNull
    private TaskTypeEnum taskType;

    @NotEmpty
    private String[] companyNo;

    private String remark;

}
