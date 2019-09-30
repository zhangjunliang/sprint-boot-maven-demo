package com.pvsky.nav.base.service;


import com.pvsky.nav.base.repository.mapper.pvskynav.TestMapper;
import com.pvsky.nav.base.repository.model.pvskynav.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestService{

	@Autowired
    private TestMapper testMapper;
    
    public Test getInfo(Integer id) {
		return testMapper.getInfoById(id);
	}
}