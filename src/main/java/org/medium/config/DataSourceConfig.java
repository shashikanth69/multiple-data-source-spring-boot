package org.medium.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    @Primary
    public DataSource dataSource(DataSourceProperties dataSourceProperties){
        final HikariDataSource dataSource = (HikariDataSource) dataSourceProperties.initializeDataSourceBuilder()
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .build();
        dataSource.setRegisterMbeans(true);
        dataSource.setConnectionTimeout(10000l); //10 secs
        return dataSource;
    }
}
