package com.db.promote.param;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @author kun
 * @version 2018-12-29 11:59
 */
@Data
public class CdkeyBatchGenerateParam {

    @Range
    private Integer batchSize;

    @Range
    private Integer validDays;
}
