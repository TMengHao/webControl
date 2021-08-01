package org.blue.service.impl;

import org.blue.entity.City;
import org.blue.mapper.CityMapper;
import org.blue.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
*/
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City selectCityById(Integer id) {
        return cityMapper.selectCityById(id);
    }
}
