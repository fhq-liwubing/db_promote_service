package com.db.promote.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2018-12-29 16:10
 */
@Data
public class EmployeeVO {

    private String employeeNo;

    private String username;

    private String selfPhone;

    private Integer state;

    private String remark;

    private String createTime;

    private String updateTime;

    private Integer terminalCount;

}
