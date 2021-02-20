package com.iit.msc.ase.tmf.commonconfig.application.controller;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iit.msc.ase.tmf.commonconfig.application.config.YAMLConfig;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.jboss.logging.MDC;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private YAMLConfig yamlConfig;

    public ObjectMapper map = new ObjectMapper();
    public ModelMapper modelMapper = new ModelMapper();

    public String mapObjToString(Object obj) {
        try {
            return map.writeValueAsString(obj);
        }
        catch ( JsonProcessingException e ) {
            logger.error("Unable to convert {} to a string", obj);
            return null;
        }
    }

    public void setLogIdentifier(HttpServletRequest request) {

        String logIdentifier = request.getHeader(yamlConfig.getLogIdentifierKey());
        if ( logIdentifier != null ) {
            MDC.put(yamlConfig.getLogIdentifierKey(), logIdentifier);
        } else {
            MDC.put(yamlConfig.getLogIdentifierKey(), UUID.randomUUID().toString());
        }
    }

}
