package com.iit.msc.ase.tmf.customermanagement.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);

    default void log(String logMessage, String... logParams) {
        if ( Boolean.TRUE.equals(logger.isDebugEnabled()) ) {
            logger.debug(logMessage, logParams);
        }
    }

}
