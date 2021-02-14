package com.iit.msc.ase.tmf.commonconfig.application.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
    //private List<String> errors;

    private String reason;
    private String code;


//    public ApiError(HttpStatus status, String message, List<String> errors) {
//        super();
//        this.status = status;
//        this.message = message;
//        this.errors = errors;
//    }
//
//    public ApiError(HttpStatus status, String message, String error) {
//        super();
//        this.status = status;
//        this.message = message;
//        errors = Arrays.asList(error);
//    }

    public ApiError(HttpStatus status, String reason, List<String> errors, String code) {
        super();
        this.status = status;
        if (errors.size() > 1) {
            this.message = String.join(",", errors);
        } else {
            this.message = errors.get(0);
        }
        this.reason = reason;
        //this.errors = errors;

        this.code = code;

    }
}
