package com.db.promote.controller;

import com.alibaba.fastjson.JSON;
import com.db.promote.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kun
 * @version 2018-12-07 19:51
 */
@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public String getAllCity() {
        return JSON.toJSONString(cityService.getAllCity());
    }

}
