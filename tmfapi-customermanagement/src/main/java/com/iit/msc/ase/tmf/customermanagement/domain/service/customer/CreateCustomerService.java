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
//import com.adl.et.telco.tmf.commonconfig.external.util.IdGenerator;
//import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
//import com.adl.et.telco.tmf.datamodel.domain.boundary.QueryGeneratorInterface;
//import com.adl.et.telco.tmf.datamodel.domain.dto.Customer;
//import com.adl.et.telco.tmf.datamodel.external.repository.PostgreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import ch.qos.logback.classic.Logger;
//
///**
// * <h1>Create Service class for Customer!</h1>
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
//public class CreateCustomerService {
//    private static final Logger logger = LoggingUtils.getLogger(CreateCustomerService.class.getName());
//    @Autowired
//    JSONConverter jsonConverter;
//    @Autowired
//    PostgreRepository postgreRepository;
//    @Autowired
//    IdGenerator idGenerator;
//    @Autowired
//    @Qualifier("postgre")
//    QueryGeneratorInterface queryGeneratorInterface;
//
//    /**
//     * Insertion of a new Customer entity to the repository and
//     * returning the newly created Customer entity
//     * @param customer This is the first parameter: Customer Object
//     * @return customer Entity
//     * @throws BaseException
//     */
//    public Customer createCustomer(Customer customer) throws BaseException {
//        logger.info("Create Customer Service");
//        String id = "";
//        if (customer.getId() != null) {
//            id = customer.getId();
//        } else {
//            id = idGenerator.generate();
//            customer.setId(id);
//        }
//        if (postgreRepository.getMemberAvailability(id, "Customer")) {
//            throw new BaseException("Duplicate Id ", "Customer Id " + id + " Already Exists", "400", HttpStatus.BAD_REQUEST);
//        } else {
//            String query = queryGeneratorInterface.insertionQuery(jsonConverter.convertToJSON(customer), id, "Customer");
//            postgreRepository.insert(query);
//            return customer;
//        }
//
//    }
//
//}
