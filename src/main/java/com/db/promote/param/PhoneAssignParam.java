package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * @author kun
 * @version 2018-12-31 11:40
 */
@Data
public class PhoneAssignParam {

    @NotBlank
    private String terminalNo;

    @Size(min = 1)
    private String[] phoneNos;

}
