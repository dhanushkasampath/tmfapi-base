package com.iit.msc.ase.tmf.commonconfig.application.exception.type;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the exception class use when service call exceptions occurred
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2020.09.15
 */
@ResponseStatus( HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceCallException extends BaseException {

    private static final long serialVersionUID = -568643381503054280L;

    public ServiceCallException(String message, String code) {
        super(message, code);
    }
}
