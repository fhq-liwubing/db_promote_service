package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2019-01-02 21:03
 */
@Data
public class EmployeeUpdateParam {

    @NotBlank
    private String employeeNo;

    private String username;

    private String selfPhone;

    private Integer state;

}
