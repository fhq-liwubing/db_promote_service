package com.db.promote.common;

import lombok.Data;

/**
 * @author kun
 * @version 2018-12-26 21:41
 */
@Data
public class PageRequest<T> {

    private Integer pageNum;

    private Integer pageRow;

    private T example;
}
