package com.db.promote.param;

import lombok.Data;

/**
 * @author kun
 * @version 2018-12-29 17:32
 */
@Data
public class TerminalQueryParam {

    private String terminalNo;

    private String employeeName;

    private String imeiNo;

    private String cdkey;

    private String province;

    private String city;

    private Integer state;

    private String remark;

}
