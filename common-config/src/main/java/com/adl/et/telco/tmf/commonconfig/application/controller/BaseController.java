package com.adl.et.telco.tmf.commonconfig.application.controller;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import com.adl.et.telco.tmf.commonconfig.application.config.YAMLConfig;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class.getName());
    @Autowired
    private YAMLConfig yamlConfig;

    public void setLogIdentifier(HttpServletRequest request) {

        String logIdentifier = request.getHeader(yamlConfig.getLogIdentifierKey());
        if (logIdentifier != null) {
            MDC.put(yamlConfig.getLogIdentifierKey(), logIdentifier);
        } else {
            MDC.put(yamlConfig.getLogIdentifierKey(), UUID.randomUUID().toString());
        }
    }
}
