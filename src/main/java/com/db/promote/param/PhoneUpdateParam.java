package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2018-12-31 10:31
 */
@Data
public class PhoneUpdateParam {

    @NotBlank
    private String phoneNo;

    private Long dataRemain;

    private Integer callRemain;

    private Integer msgRemain;

    private String ownerName;

    private String idCardNo;

    private String wechatNo;

    private String wechatName;

    private String payPassword;

    private Integer state;

}
