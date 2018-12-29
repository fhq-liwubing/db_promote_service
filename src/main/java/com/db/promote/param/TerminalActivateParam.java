package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2018-12-28 14:39
 */
@Data
public class TerminalActivateParam {

    @NotBlank
    private String identityNo;

    @NotBlank
    private String imeiNo;

    @NotBlank
    private String cdkey;

    private String province;

    private String city;

}
