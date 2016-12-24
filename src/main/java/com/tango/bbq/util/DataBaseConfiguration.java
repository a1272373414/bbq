package com.tango.bbq.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:dbConfig/front_133_3306.properties")
@PropertySource("classpath:dbConfig/front_133_3307.properties")
public class DataBaseConfiguration{
	
//	private RelaxedPropertyResolver propertyResolver;  
	
//	@Override
//	public void setEnvironment(Environment environment) {
//		this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
//	} 
	
//	@Bean(destroyMethod = "close", initMethod = "init")  
//    public DataSource writeDataSource() {  
//        DruidDataSource dataSource = new DruidDataSource();  
//        dataSource.setUrl(propertyResolver.getProperty("url"));  
//        dataSource.setUsername(propertyResolver.getProperty("username"));//用户名  
//        dataSource.setPassword(propertyResolver.getProperty("password"));//密码  
//        dataSource.setDriverClassName(propertyResolver.getProperty("driverClassName"));  
//        dataSource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));  
//        dataSource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));  
//        dataSource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));  
//        dataSource.setMaxWait(Long.valueOf(propertyResolver.getProperty("maxWait")));  
//        dataSource.setValidationQuery(propertyResolver.getProperty("validationQuery"));  
//        dataSource.setTestOnBorrow(false);  
//        dataSource.setTestWhileIdle(true);  
//        dataSource.setPoolPreparedStatements(false);  
//        return dataSource;  
//    }  
	
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mysql_202_186_3306")
    public DataSource primaryDataSource(){
      return new DruidDataSource();  
    }
    
    @Bean(name = "thirdDataSource")
    @Qualifier("thirdDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mysql_217_11_3309")
    public DataSource thirdDataSource(){
      return new DruidDataSource();  
    }
    
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql_203_67_3306")
    public DataSource secondaryDataSource(){
      return new DruidDataSource(); 
    }
    
    
    @Bean(name = "otherDataSource")
    @Qualifier("otherDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql_193_133_3306")
    public DataSource otherDataSource(){
      return new DruidDataSource(); 
    }
    
    @Bean(name = "other1DataSource")
    @Qualifier("other1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql_193_133_3307")
    public DataSource other1DataSource(){
      return new DruidDataSource(); 
    }

    
    
    
    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "thirdJdbcTemplate")
    public JdbcTemplate thirdJdbcTemplate(@Qualifier("thirdDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "otherJdbcTemplate")
    public JdbcTemplate otherJdbcTemplate(@Qualifier("otherDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "other1JdbcTemplate")
    public JdbcTemplate other1JdbcTemplate(@Qualifier("other1DataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
 
    
    
}
