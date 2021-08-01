package org.blue.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.blue.entity.City;

/**
* @Entity org.blue.entity.City
*/
@Mapper
public interface CityMapper{

    @Select("select * from city where id = #{id}")
    @Options(useGeneratedKeys = true)
    City selectCityById(Integer id);

}
