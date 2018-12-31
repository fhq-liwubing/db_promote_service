package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author kun
 * @version 2018-12-31 10:28
 */
@Data
public class PhoneAddParam {

    @NotBlank
    @Length(min = 11, max = 11)
    private String phoneNo;

    @NotBlank
    private String idCardNo;

    @NotBlank
    private String ownerName;

    private Long dataRemain;

    private Integer callRemain;

    private Integer msgRemain;

    private String wechatNo;

    private String wechatName;

    private String payPassword;
}
