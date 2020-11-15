package com.adl.et.telco.tmf.commonconfig.application.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
//    public @Bean
//    Session session() {
//        Cluster cluster = Cluster.builder().addContactPoints("104.211.188.151").build();
//        return cluster.connect("tmf_db");
//        Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
//        return cluster.connect("tmf_db_test");
//    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
