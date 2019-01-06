package com.db.promote.common;

/**
 * @author kun
 * @version 2019-01-06 15:01
 */
public enum TagTypeEnum {

    /**
     * 标签类型
     */
    PROGRESS("0", "进度标签"),

    SCORE("1", "评分标签"),

    CUSTOM("2", "自定义标签");

    private String code;

    private String description;

    TagTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TagTypeEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        TagTypeEnum[] values = TagTypeEnum.values();
        for (TagTypeEnum value : values) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }

}
