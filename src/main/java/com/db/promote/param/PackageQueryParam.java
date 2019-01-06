package com.db.promote.param;

import com.db.promote.util.constants.ProcessStatusEnum;
import com.db.promote.util.constants.TaskTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kun
 * @version 2019-01-06 10:44
 */
@Data
public class PackageQueryParam {

    /**
     * 任务包名称
     */
    private String packageName;

    /**
     * 任务类型
     */
    private TaskTypeEnum taskType;

    /**
     * 进度状态
     */
    private ProcessStatusEnum processStatus;

    private LocalDateTime createTimeFrom;

    private LocalDateTime createTimeTo;

    private LocalDateTime finishTimeFrom;

    private LocalDateTime finishTimeTo;

}
