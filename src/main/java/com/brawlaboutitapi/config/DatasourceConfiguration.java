package com.brawlaboutitapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfiguration {

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://brawlaboutit.cyiuwebpucbk.us-east-2.rds.amazonaws.com:3306/brawlaboutit");
        config.setUsername("admin");
        config.setPassword("An0nym0us4500");
        config.setDriverClassName("com.mysql.jdbc.Driver");
        return new HikariDataSource(config);
    }
}
