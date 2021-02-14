package com.iit.msc.ase.tmf.commonconfig.application.exception;


import com.iit.msc.ase.tmf.commonconfig.application.exception.type.BaseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> errors = new ArrayList<String>();
        int count = 0;
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            count = count + 1;
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            count = count + 1;
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        String reason = "Validation failed for object = '" + ex.getBindingResult().getObjectName() + "'. Error count: " + count;
        ApiError apiError =
                new ApiError(status, reason, errors, String.valueOf(status.value()));
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> customExceptionHandler(BaseException ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setCode(ex.getCode());
        errors.setReason(ex.getReason());
        errors.setStatus(ex.getStatus());
        errors.setMessage(ex.getMessage());

        return new ResponseEntity<>(errors, ex.getStatus());

    }
}
