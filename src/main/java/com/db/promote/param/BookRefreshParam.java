package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author kun
 * @version 2019-01-06 17:17
 */
@Data
public class BookRefreshParam {

    @NotBlank
    private String phoneNo;

    @NotEmpty
    private BookInfo[] infoList;

    @Data
    public static class BookInfo {

        private String contactName;

        private String contactPhone;

        private String contactCompanyNo;

        private String contactCompanyName;

        private String contactAddress;

        private String contactEmail;

        private String contactWechat;

        private String remark;
    }

}
