package com.toy.server.config.dataBase;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by ghq on 2018/4/24.
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "ctradeDataSource")
    @Qualifier("ctradeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ctrade")
    public DataSource ctradeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jsfDataSource")
    @Qualifier("jsfDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.jsf")
    public DataSource jsfDataSource() {
        return DataSourceBuilder.create().build();
    }
}
