package com.iit.msc.ase.tmf.customermanagement.domain.service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public interface CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);

    default void log(String logMessage, String... logParams) {
        if ( Boolean.TRUE.equals(logger.isDebugEnabled()) ) {
            logger.debug(logMessage, logParams);
        }
    }

}
