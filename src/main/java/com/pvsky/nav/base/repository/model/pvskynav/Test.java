package com.pvsky.nav.base.repository.model.pvskynav;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Test {
	private Integer id;
	private String name;
	private Timestamp create_time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateTime() {
		DateFormat df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(create_time);
	}
	public void setCreateTime(Timestamp create_time) {
		this.create_time = create_time;
	}
}
