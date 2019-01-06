package com.db.promote.util.constants;

/**
 * @author kun
 * @version 2019-01-06 10:46
 */
public enum TaskTypeEnum {

    /**
     * 任务类型描述
     */
    CALL("0", "电话任务"),

    MSG("1", "短信任务"),

    SUPPLEMENTARY("2", "信息补充任务"),

    WECHAT("3", "微信任务");

    private String code;

    private String description;

    TaskTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TaskTypeEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (TaskTypeEnum value : TaskTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
