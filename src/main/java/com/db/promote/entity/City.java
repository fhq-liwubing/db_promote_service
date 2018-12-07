package com.db.promote.entity;

import lombok.Data;

/**
* Created by Mybatis Generator 2018/12/07
*/
@Data
public class City {
    private Integer id;

    /* 城市名称*/
    private String cityName;

    /* 父id*/
    private Integer fid;

    /*  大区表id*/
    private String regionId;
}