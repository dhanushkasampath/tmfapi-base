package com.adl.et.telco.tmf.commonconfig.application.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomErrorResponse {
    private HttpStatus status;
    private String message;
    private String reason;
    private String code;
}
