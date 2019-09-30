package com.pvsky.nav.base.configuration;

import org.apache.ibatis.session.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mybatis.configuration")
public class NavMybatisConfiguration extends Configuration {

}
