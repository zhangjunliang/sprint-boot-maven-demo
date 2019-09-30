package com.pvsky.nav.base.repository.mapper.pvskynav;

import com.pvsky.nav.base.repository.model.pvskynav.Test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

    @Select("select * from test where id = #{id}")
	Test getInfoById(@Param("id") Integer id);
}
