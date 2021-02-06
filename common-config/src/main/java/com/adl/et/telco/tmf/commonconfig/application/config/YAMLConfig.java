package com.adl.et.telco.tmf.commonconfig.application.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Getter
@Setter
public class YAMLConfig {

//    @Value("${log.identifierKey}")
    private String logIdentifierKey;

}
