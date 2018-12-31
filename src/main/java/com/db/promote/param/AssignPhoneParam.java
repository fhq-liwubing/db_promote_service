package com.db.promote.param;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2018-12-31 09:53
 */
@Data
public class AssignPhoneParam {

    private String terminalNo;

    private String phoneNo;

    private LocalDateTime assignTimeFrom;

    private LocalDateTime assignTimeTo;

}
