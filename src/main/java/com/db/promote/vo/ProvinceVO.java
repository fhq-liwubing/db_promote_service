package com.db.promote.vo;

import lombok.Data;

import java.util.List;

/**
 * @author kun
 * @version 2018-12-07 19:56
 */
@Data
public class ProvinceVO {

    private String value;

    private String label;

    private List<CityVO> children;

}
