package com.db.promote.util.constants;

/**
 * @author: hxy
 * @date: 2017/10/24 10:16
 */
public enum ErrorEnum {
    /*
     * 错误信息
     * */
    E_400("400", "请求处理异常，请稍后再试"),
    E_500("500", "请求方式有误,请检查 GET/POST"),
    E_501("501", "请求路径不存在"),
    E_502("502", "权限不足"),
    E_10008("10008", "角色删除失败,尚有用户属于此角色"),
    E_10009("10009", "账户已存在"),

    E_20011("20011", "登陆已过期,请重新登陆"),

    E_90003("90003", "缺少必填参数"),

    E_4000("4000", "数据不存在"),
    E_4001("4001", "短信验证码发送失败"),
    E_4002("4002", "短信验证码校验失败"),
    E_4004("4004", "激活码已使用"),
    E_4005("4005", "激活码已过期"),
    E_4006("4006", "设备未激活"),
    E_4007("4007", "设备状态不可用"),
    E_4008("4008", "设备验证失败"),
    E_4009("4009", "存在同名员工，请指定员工编号"),
    E_4010("4010", "文件已存在")
    ;

    private String errorCode;

    private String errorMsg;

    ErrorEnum() {
    }

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
