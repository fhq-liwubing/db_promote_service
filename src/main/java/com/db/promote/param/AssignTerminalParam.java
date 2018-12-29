package com.db.promote.param;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2018-12-29 17:29
 */
@Data
public class AssignTerminalParam {

    private String terminalNo;

    private String employeeNo;

    private String employeeName;

    private LocalDateTime assignTimeFrom;

    private LocalDateTime assignTimeTo;

}
