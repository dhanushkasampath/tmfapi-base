package com.adl.et.telco.tmf.commonconfig.application.exception.type;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseException extends Exception {
    private String code;
    private HttpStatus status;
    private String reason;
    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, String reason, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
        this.reason = reason;
    }
}
