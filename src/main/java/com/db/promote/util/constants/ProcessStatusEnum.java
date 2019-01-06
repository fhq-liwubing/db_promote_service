package com.db.promote.util.constants;

/**
 * @author kun
 * @version 2019-01-06 10:54
 */
public enum ProcessStatusEnum {

    /**
     * 任务状态
     */
    INIT("0", "未分配"),

    ASSIGNED("1", "已分配"),

    COMPLETED("2", "已完成");

    private String code;

    private String description;

    ProcessStatusEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ProcessStatusEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        ProcessStatusEnum[] values = ProcessStatusEnum.values();
        for (ProcessStatusEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

}
