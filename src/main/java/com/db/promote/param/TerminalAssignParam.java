package com.db.promote.param;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author kun
 * @version 2018-12-31 11:18
 */
@Data
public class TerminalAssignParam {

    /**
     * 姓名或者编号
     */
    private String username;

    private String employeeNo;

    @Size(min = 1)
    private String[] terminalNos;

}
