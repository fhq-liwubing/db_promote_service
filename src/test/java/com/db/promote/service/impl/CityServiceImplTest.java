package com.db.promote.service.impl;

import com.db.promote.service.CityService;
import com.db.promote.vo.ProvinceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kun
 * @version 2018-12-07 20:23
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CityServiceImplTest {

    @Autowired
    private CityService cityService;

    @Test
    public void getAllCity() {
        List<ProvinceVO> all = cityService.getAllCity();
        System.out.println(all);
    }
}