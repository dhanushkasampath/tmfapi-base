package com.iit.msc.ase.tmf.commonconfig.application.exception.type;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the exception class related to this application
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.03.07
 */
@ResponseStatus( HttpStatus.BAD_REQUEST )
public class CustomerMgtException extends BaseException {

    private static final long serialVersionUID = 13665L;

    public CustomerMgtException(String message, String code) {
        super(message, code);
    }

}
