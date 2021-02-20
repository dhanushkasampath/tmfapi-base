///**
// * © Copyrights 2020 Axiata Digital Labs Pvt Ltd.
// * All Rights Reserved.
// *
// * These material are unpublished, proprietary, confidential source
// * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
// * SECRET of ADL.
// *
// * ADL retains all title to and intelectual property rights in these
// * materials.
// */
//
//package com.adl.et.telco.tmf.customermanagement.domain.service.customer;
//
//import com.adl.et.telco.dte.plugin.log.services.LoggingUtils;
//import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
//import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
//import com.adl.et.telco.tmf.datamodel.domain.boundary.EntityGeneratorInterface;
//import com.adl.et.telco.tmf.datamodel.domain.dto.Customer;
//import com.adl.et.telco.tmf.datamodel.external.repository.PostgreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//import ch.qos.logback.classic.Logger;
//
///**
// * <h1>Get All and Get by ID Service class for Customer!</h1>
// *
// * <p>
// * <b>Note:</b>
// *
// * @author  Sharada Deshan
// * @version 1.0
// * @since   2020-02-01
// */
//
//@Service
//public class GetCustomerService {
//    private static final Logger logger = LoggingUtils.getLogger(GetCustomerService.class.getName());
//    @Autowired
//    JSONConverter jsonConverter;
//    @Autowired
//    @Qualifier("postgreEntityGenerator")
//    EntityGeneratorInterface entityGeneratorInterface;
//    @Autowired
//    PostgreRepository postgreRepository;
//
//    /**
//     * List all Customer
//     *
//     * @param fields Comma-separated properties to be provided in response
//     * @param offset Requested index for start of resources to be provided in response
//     * @param limit Requested number of resources to be provided in response
//     * @param filters Key and value pair that needs to be filtered
//     * @return List<Customer> This returns a list of Customer
//     * @throws BaseException
//     */
//    public List<Customer> getAllCustomers(String fields, Integer offset, Integer limit, Map<String, String> filters) throws BaseException {
//        logger.info("Get All Customers");
//        return jsonConverter.convertToObjectList(entityGeneratorInterface.generateResponseJSON("Customer", filters, ""), "Customer");
//
//    }
//
//    /**
//     * Get a single Customer Entity by ID
//     *
//     * @param   id          Specific Customer id
//     * @param   fields      Comma-separated properties to be provided in response
//     * @param   filters     Key and value pair that needs to be filtered
//     * @return  Customer
//     * @throws BaseException if error occurs in Customer selection
//     */
//    public Customer getCustomerById(String id, String fields, Map<String, String> filters) throws BaseException {
//        logger.info("Get Customer By Id");
//        if (postgreRepository.getMemberAvailability(id, "Customer")) {
//            return (Customer) jsonConverter.convertToObject(entityGeneratorInterface.generateResponseJSON("Customer", filters, id).getJSONObject(0), "Customer");
//        } else {
//            throw new BaseException("Not found", "No Customer Found", "404", HttpStatus.NOT_FOUND);
//        }
//
//    }
//}
