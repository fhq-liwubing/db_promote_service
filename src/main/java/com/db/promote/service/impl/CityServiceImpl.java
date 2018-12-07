package com.db.promote.service.impl;

import com.db.promote.dao.CityMapper;
import com.db.promote.service.CityService;
import com.db.promote.vo.ProvinceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kun
 * @version 2018-12-07 19:53
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<ProvinceVO> getAllCity() {
        return cityMapper.selectProvinces();
    }

}
