package com.pvsky.nav.base.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;


@EnableConfigurationProperties(NavMybatisConfiguration.class)
@MapperScan(basePackages = "com.pvsky.nav.base.repository.mapper.pvskynav", sqlSessionFactoryRef = "navSqlSessionFactory")
@Configuration
public class NavDataSourceConfig{
    private final NavMybatisConfiguration configuration;

	public NavDataSourceConfig(NavMybatisConfiguration configuration) {
		this.configuration = configuration;
	}
	
	@Primary
	@Bean(name = "navDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.nav")
	public DataSource getNavDataSource() {
		return new DruidDataSource();
	}

	@Bean(name = "navSqlSessionFactory")
	public SqlSessionFactory navSqlSessionFactory(@Qualifier("navDataSource") DataSource datasource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/pvskynav/*.xml"));
	    bean.setConfiguration(configuration);
		return bean.getObject();
	}

    @Primary
	@Bean(name = "navTransactionManager")
    public DataSourceTransactionManager navTransactionManager(@Qualifier("navDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

	@Primary
	@Bean("navSqlSessionTemplate")
	public SqlSessionTemplate navSqlSessionTemplate(@Qualifier("navSqlSessionFactory") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}
}
