/**
 * Copyrights 2020 Axiata Digital Labs Pvt Ltd.
 * All Rights Reserved.
 * <p>
 * These material are unpublished, proprietary, confidential source
 * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
 * SECRET of ADL.
 * <p>
 * ADL retains all title to and intellectual property rights in these
 * materials.
 */
package com.iit.msc.ase.tmf.commonconfig.application.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.iit.msc.ase.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.commonconfig.domain.dto.headers.ResponseHeaderDto;
import com.iit.msc.ase.tmf.commonconfig.external.util.Constants;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;


@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    private static final String RESPONSE_HEADER_TEXT = "responseHeader";

    @Override
    public Map < String, Object > getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Throwable error = getError(webRequest);
        if ( error == null ) {
            return null;
        }
        switch ( error.getClass().getSimpleName() ) {
            case "ValidationException":
            case "ControllerException":
            case "FilterException":
            case "DomainException":
            case "MethodArgumentNotValidException":
                return handleMethodArgumentNotValidException(( MethodArgumentNotValidException ) error);
            case "CustomerMgtException":
                return handleCustomerMgtException(( BaseException ) error);
            case "WebClientException":
                return handleRecoverableException(( BaseException ) error, includeStackTrace);
            case "ServiceCallException":
                return handleServiceCallException(( BaseException ) error);
            default:
                return handleGenericException(error);
        }
    }

    /**
     * Handle my five service exceptions
     *
     * @param error exception
     * @return error description
     */
    private Map < String, Object > handleServiceCallException(BaseException error) {
        Map < String, Object > errorDetails = new LinkedHashMap <>();
        errorDetails.put(RESPONSE_HEADER_TEXT, generateResponseHeaderDto("123", "400", error.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), error.getCode()));
        return errorDetails;
    }

    /**
     * @param error
     * @return
     */
    private Map < String, Object > handleGenericException(Throwable error) {
        Map < String, Object > errorDetails = new LinkedHashMap <>();
        errorDetails.put(RESPONSE_HEADER_TEXT, generateResponseHeaderDto("123", "400", error.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), Constants.TMF_COMMON_CONST_2001));
        return errorDetails;
    }

    /**
     * @param error
     * @return
     */
    private Map < String, Object > handleMethodArgumentNotValidException(MethodArgumentNotValidException error) {
        Map < String, Object > errorDetails = new LinkedHashMap <>();
        errorDetails.put(RESPONSE_HEADER_TEXT, generateResponseHeaderDto("123", "400", Objects.requireNonNull(error.getBindingResult().getFieldError()).getDefaultMessage(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), Constants.TMF_COMMON_CONST_2002));
        return errorDetails;
    }

    /**
     * @param error
     * @return
     */
    private Map < String, Object > handleCustomerMgtException(BaseException error) {
        Map < String, Object > errorDetails = new LinkedHashMap <>();
        errorDetails.put(RESPONSE_HEADER_TEXT, generateResponseHeaderDto("123", "400", error.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME), error.getCode()));
        return errorDetails;
    }

    /**
     * Handle recoverable exceptions
     *
     * @param error exception
     * @return error description
     */
    private Map < String, Object > handleRecoverableException(BaseException error,
                                                              boolean includeStackTrace) {

        Map < String, Object > errorDetails = new LinkedHashMap <>();

        errorDetails.put("code", error.getCode() != null ? error.getCode() : "400");
        errorDetails.put("type", error.getClass().getSimpleName());
        errorDetails.put("message", error.getMessage());

        if ( includeStackTrace ) {
            errorDetails.put("trace", this.getStackTrace(error));
        }
        return errorDetails;
    }


    /**
     * Get stack trace from an exception
     *
     * @param error exception
     * @return stack trace
     */
    private String getStackTrace(Throwable error) {

        StringWriter stackTrace = new StringWriter();
        error.printStackTrace(new PrintWriter(stackTrace));
        stackTrace.flush();

        return stackTrace.toString();
    }

    /**
     * @param requestId
     * @param responseCode
     * @param responseDesc
     * @param timeStamp
     * @param responseDescDisplay
     * @return
     */
    private ResponseHeaderDto generateResponseHeaderDto(String requestId, String responseCode, String responseDesc, String timeStamp, String responseDescDisplay) {
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        responseHeaderDto.setRequestId(requestId);
        responseHeaderDto.setResponseCode(responseCode);
        responseHeaderDto.setResponseDesc(responseDesc);
        responseHeaderDto.setTimestamp(timeStamp);
        responseHeaderDto.setResponseDescDisplay(responseDescDisplay);
        return responseHeaderDto;
    }

}
