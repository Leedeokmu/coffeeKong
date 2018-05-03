package com.coffeekong;

import com.coffeekong.annotation.mapper.CoffeekongMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;

@Configuration
@Lazy
@MapperScan(basePackages="com.coffeekong.mapper", annotationClass = CoffeekongMapper.class, sqlSessionFactoryRef = "sqlSessionFactory")
public class DBConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean(name = "dataSource")
    @Qualifier(value = "dataSource")
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource(){ return DataSourceBuilder.create().build();}

    @Bean
    @Qualifier(value = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
