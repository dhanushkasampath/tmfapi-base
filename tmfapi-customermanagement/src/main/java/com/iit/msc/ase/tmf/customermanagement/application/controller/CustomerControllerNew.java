package com.iit.msc.ase.tmf.customermanagement.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.iit.msc.ase.tmf.commonconfig.application.controller.BaseController;
import com.iit.msc.ase.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.TimePeriodService;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-14
 */
@RestController
@RequestMapping( value = "/tmf-api/customerManagement/v4/customer" )
public class CustomerControllerNew extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerNew.class);

    @Autowired
    private TimePeriodService timePeriodService;

    @Autowired
    private CustomerService customerService;


    @PostMapping( value = "",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity createCustomer(
            @Valid
            @RequestBody( required = true )
                    CreateCustomerReqDto createCustomerReqDto, HttpServletRequest request) throws BaseException {
        logger.debug("Received request to create customer:{}", mapObjToString(createCustomerReqDto));
        CreateCustomerRespDto createCustomerRespDto = customerService.create(createCustomerReqDto);
        logger.debug("Return response after creating a customer|createCustomerRespDto:{}", mapObjToString(createCustomerRespDto));
        return new ResponseEntity <>(createCustomerRespDto, HttpStatus.valueOf(createCustomerRespDto.getResponseHeader().getResponseCode()));
    }

}
