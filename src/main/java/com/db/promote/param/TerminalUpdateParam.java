package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2018-12-29 18:45
 */
@Data
public class TerminalUpdateParam {

    @NotBlank
    private String terminalNo;

    private String province;

    private String city;

    private Integer state;

}
