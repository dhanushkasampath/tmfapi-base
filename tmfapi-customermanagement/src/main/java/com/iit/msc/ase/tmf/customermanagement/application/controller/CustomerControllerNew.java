package com.iit.msc.ase.tmf.customermanagement.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.iit.msc.ase.tmf.commonconfig.application.controller.BaseController;
import com.iit.msc.ase.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.TimePeriodService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.TimePeriod;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
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

//    @Autowired
//    private TimePeriodService timePeriodService;

    /**
     * This method is to create a customer entity.
     *
     * @param customerDto This is the first parameter
     * @param request     This is the second parameter
     * @return ResponseEntity This returns created customer entity
     * @throws BaseException
     */
    @PostMapping( value = "",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity createCustomer(
            @Valid
            @RequestBody( required = true )
                    CustomerDto customerDto, HttpServletRequest request) throws BaseException {
//        setLogIdentifier(request);
        logger.debug("create customer");

        TimePeriod timePeriod = modelMapper.map(customerDto.getValidFor(), TimePeriod.class);
        logger.debug("create customer ended");
//        timePeriodService.create(timePeriod);
        //how
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
