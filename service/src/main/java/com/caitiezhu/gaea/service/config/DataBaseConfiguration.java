package com.caitiezhu.gaea.service.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author cai yang
 * @Date 2020/1/19 3:26 下午
 **/
@Configuration
@MapperScan("com.caitiezhu.gaea.service.dao")
public class DataBaseConfiguration {
    private String driver = "com.mysql.cj.jdbc.Driver";

    @NacosValue("${spring.datasource.url:jdbc:mysql://47.96.173.145:3306/gaea}")
    private String url;

    @NacosValue("${spring.datasource.username:root}")
    private String username;

    @NacosValue("${spring.datasource.password:123456}")
    private String password;

    @Bean
    public PooledDataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
