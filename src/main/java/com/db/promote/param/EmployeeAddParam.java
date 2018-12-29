package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2018-12-29 18:39
 */
@Data
public class EmployeeAddParam {

    @NotBlank
    private String username;

    @NotBlank
    private String selfPhone;

    private String remark;
}
