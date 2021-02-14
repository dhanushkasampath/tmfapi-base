package com.iit.msc.ase.tmf.customermanagement.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.adl.et.telco.tmf.commonconfig.application.controller.BaseController;
import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.datamodel.domain.dto.Customer;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
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

    /**
     * This method is to create a customer entity.
     * @param customer This is the first parameter
     * @param request  This is the second parameter
     * @return ResponseEntity This returns created customer entity
     * @throws BaseException
     */
    @PostMapping( value = "",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity createCustomer(
            @Valid
            @RequestBody( required = true )
                    Customer customer, HttpServletRequest request) throws BaseException {
        setLogIdentifier(request);
        logger.debug("create customer");
        //how
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
