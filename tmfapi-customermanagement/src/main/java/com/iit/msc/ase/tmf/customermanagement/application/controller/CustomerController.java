/**
 * © Copyrights 2020 Axiata Digital Labs Pvt Ltd.
 * All Rights Reserved.
 * <p>
 * These material are unpublished, proprietary, confidential source
 * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
 * SECRET of ADL.
 * <p>
 * ADL retains all title to and intelectual property rights in these
 * materials.
 */

package com.iit.msc.ase.tmf.customermanagement.application.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.adl.et.telco.tmf.commonconfig.application.controller.BaseController;
import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.datamodel.domain.dto.Customer;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Customer Controller!</h1>
 * <p>
 * <b>Note:</b>
 *
 * @author Sharada Deshan
 * @version 1.0
 * @since 2020-02-01
 */

@RestController
@RequestMapping( value = "/tmf-api/customerManagement/v4/customer" )
public class CustomerController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CreateCustomerService createCustomerService;

    @Autowired
    GetCustomerService getCustomerService;

    @Autowired
    UpdateCustomerService updateCustomerService;

    @Autowired
    DeleteCustomerService deleteCustomerService;

    @Autowired
    PutCustomerService putCustomerService;

    /**
     * This operation list customer entities.
     * Attribute selection is enabled for all first level attributes.
     * Filtering may be available depending on the compliance level supported by an implementation.
     *
     * @param filters This is the first parameter
     * @param fields  This is the second parameter
     * @param offset  This is the third parameter
     * @param limit   This is the fourth parameter
     * @param request This is the fifth parameter
     * @return ResponseEntity This returns list customer entities
     * @throws BaseException
     */
    @GetMapping( value = "",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity getAllCustomers(
            @ApiParam( hidden = false )
            @RequestParam( required = false )
                    Map < String, String > filters,
            @RequestParam( required = false )
                    String fields,
            @RequestParam( required = false )
                    Integer offset,
            @RequestParam( required = false )
                    Integer limit, HttpServletRequest request) throws BaseException {
        setLogIdentifier(request);
        logger.debug("get all customers");
        return ResponseEntity.status(HttpStatus.OK).body(getCustomerService.getAllCustomers(fields, offset, limit, filters));
    }

    /**
     * This method is to create a customer entity.
     *
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
        return ResponseEntity.status(HttpStatus.OK).body(createCustomerService.createCustomer(customer));
    }

    /**
     * This method is to retrieves a customer entity.
     * Attribute selection is enabled for all first level attributes.
     * Filtering on sub-resources may be available depending on the
     * compliance level supported by an implementation.
     *
     * @param filters This is the first parameter
     * @param id      This is the path variable
     * @param fields  This is the second parameter
     * @param request This is the third parameter
     * @return ResponseEntity This returns information about the single customer entity
     * @throws BaseException
     */
    @GetMapping( value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity getCustomerById(
            @ApiParam( hidden = false )
            @RequestParam( required = false )
                    Map < String, String > filters,
            @PathVariable( "id" )
                    String id,
            @RequestParam( required = false )
                    String fields, HttpServletRequest request) throws BaseException {
        setLogIdentifier(request);
        logger.debug("get customer by id");
        return ResponseEntity.status(HttpStatus.OK).body(getCustomerService.getCustomerById(id, fields, filters));
    }

    /**
     * This method allows partial updates of a customer entity.
     *
     * @param id       This is the path variable
     * @param customer This is the first parameter
     * @param request  This is the second parameter
     * @return ResponseEntity This returns modified resource
     * @throws BaseException
     */
    @PatchMapping( value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity updateCustomerById(
            @PathVariable( "id" )
                    String id,
            @RequestBody
                    Customer customer, HttpServletRequest request) throws BaseException {
        setLogIdentifier(request);
        logger.debug("update Customer by id");
        return ResponseEntity.status(HttpStatus.OK).body(updateCustomerService.updateCustomerById(id, customer));

    }

    /**
     * This method is to delete customer entity.
     *
     * @param id      This is the path variable
     * @param request This is the second parameter
     * @return ResponseEntity
     * @throws BaseException
     */
    @DeleteMapping( value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity deleteCustomerById(
            @PathVariable( "id" )
                    String id, HttpServletRequest request) throws BaseException {
        setLogIdentifier(request);
        logger.debug("delete customer by id");
        deleteCustomerService.deleteCustomerById(id);
        return ResponseEntity.status(204).body("");

    }

}
