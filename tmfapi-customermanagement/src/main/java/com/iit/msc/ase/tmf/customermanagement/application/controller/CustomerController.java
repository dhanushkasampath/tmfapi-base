package com.iit.msc.ase.tmf.customermanagement.application.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.iit.msc.ase.tmf.commonconfig.application.controller.BaseController;
import com.iit.msc.ase.tmf.commonconfig.application.exception.type.CustomerMgtException;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryAllCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryCustomerByIdRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerRespDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-14
 */
@RestController
@RequestMapping( value = "/tmf-api/customerManagement/v4/customer" )
public class CustomerController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( path = "/test-hello-app",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity test(HttpServletRequest request) {
        if ( logger.isInfoEnabled() ) {
            logger.info("Received request to test the hello app");
        }
        if ( logger.isInfoEnabled() ) {
            logger.info("Return response after testing the hello app");
        }
        return new ResponseEntity <>("hello-app is working!!", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping( value = "",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity createCustomer(
            @Valid
            @RequestBody( required = true )
                    CreateCustomerReqDto createCustomerReqDto, HttpServletRequest request) {
        if ( logger.isInfoEnabled() ) {
            logger.info("Received request to create customer:{}", mapObjToString(createCustomerReqDto));
        }
        CreateCustomerRespDto createCustomerRespDto = customerService.create(createCustomerReqDto);
        if ( logger.isInfoEnabled() ) {
            logger.info("Return response after creating a customer|createCustomerRespDto:{}", mapObjToString(createCustomerRespDto));
        }
        return new ResponseEntity <>(createCustomerRespDto, HttpStatus.valueOf(Integer.parseInt(createCustomerRespDto.getResponseHeader().getResponseCode())));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( value = "",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity queryAllCustomers(
            @RequestParam( required = false )
                    Map < String, String > filters,
            @RequestParam( required = false )
                    String fields,
            @RequestParam( value = "offset",
                    required = true )
                    String offset,
            @RequestParam( value = "limit",
                    required = true )
                    String limit, HttpServletRequest request) throws CustomerMgtException {
        if ( logger.isInfoEnabled() ) {
            logger.info("Received request to query all customers|fields:{}|filters:{}|offset:{}|limit:{}", fields, filters, offset, limit);
        }
        QueryAllCustomerRespDto queryAllCustomerRespDto = customerService.queryAll(filters, fields, Integer.parseInt(offset), Integer.parseInt(limit));
        if ( logger.isInfoEnabled() ) {
            logger.info("Return response after querying all customers|:{}", mapObjToString(queryAllCustomerRespDto));
        }
        return new ResponseEntity <>(queryAllCustomerRespDto, HttpStatus.valueOf(Integer.parseInt(queryAllCustomerRespDto.getResponseHeader().getResponseCode())));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping( value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity queryCustomerById(
            @PathVariable( name = "id",
                    required = true )
                    String id,
            HttpServletRequest request) {
        if ( logger.isInfoEnabled() ) {
            logger.info("Received request to query customer by id:{}", id);
        }
        QueryCustomerByIdRespDto queryCustomerByIdRespDto = customerService.queryById(id);
        if ( logger.isInfoEnabled() ) {
            logger.info("Return response after querying customer by id:{}|{}", id, mapObjToString(queryCustomerByIdRespDto));
        }
        return new ResponseEntity <>(queryCustomerByIdRespDto, HttpStatus.valueOf(Integer.parseInt(queryCustomerByIdRespDto.getResponseHeader().getResponseCode())));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping( value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity deleteCustomerById(
            @PathVariable( name = "id",
                    required = true )
                    String id,
            HttpServletRequest request) {
        if ( logger.isInfoEnabled() ) {
            logger.info("Received request to delete customer by id:{}", id);
        }
        customerService.deleteById(id);
        if ( logger.isInfoEnabled() ) {
            logger.info("Return response after deleting customer by id:{}", id);
        }
        return new ResponseEntity <>(null, HttpStatus.NO_CONTENT);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping( value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity updateCustomer(
            @PathVariable( name = "id",
                    required = true )
                    String id,
            @Valid
            @RequestBody( required = true )
                    UpdateCustomerReqDto updateCustomerReqDto, HttpServletRequest request) throws CustomerMgtException {
        if ( logger.isInfoEnabled() ) {
            logger.info("Received request to update customer|id:{}|updateCustomerReqDto:{}", id, mapObjToString(updateCustomerReqDto));
        }
        UpdateCustomerRespDto updateCustomerRespDto = customerService.update(id, updateCustomerReqDto);
        if ( logger.isInfoEnabled() ) {
            logger.info("Return response after updating a customer|updateCustomerRespDto:{}", mapObjToString(updateCustomerRespDto));
        }
        return new ResponseEntity <>(updateCustomerRespDto, HttpStatus.valueOf(Integer.parseInt(updateCustomerRespDto.getResponseHeader().getResponseCode())));
    }

}
