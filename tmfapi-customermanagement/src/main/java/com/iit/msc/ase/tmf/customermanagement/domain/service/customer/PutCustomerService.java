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
//import com.adl.et.telco.tmf.datamodel.domain.boundary.QueryGeneratorInterface;
//import com.adl.et.telco.tmf.datamodel.domain.dto.Customer;
//import com.adl.et.telco.tmf.datamodel.external.repository.PostgreRepository;
//import com.adl.et.telco.tmf.datamodel.external.util.PostgrePutQueryGenerator;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import ch.qos.logback.classic.Logger;
//
///**
// * <h1>Put Service class for Customer!</h1>
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
//public class PutCustomerService {
//    private static final Logger logger = LoggingUtils.getLogger(UpdateCustomerService.class.getName());
//
//    @Autowired
//    JSONConverter jsonConverter;
//    @Autowired
//    PostgreRepository postgreRepository;
//    @Autowired
//    @Qualifier("postgre")
//    QueryGeneratorInterface queryGeneratorInterface;
//    @Autowired
//    PostgrePutQueryGenerator postgrePutQueryGenerator;
//
//    /**
//     * Put Opeation for a Customer Entity identified by ID
//     *
//     * @param id        Specific Customer id
//     * @param customer This is the first parameter
//     * @return customer This returns updated customer entity
//     * @throws BaseException if error occurs in Customer update
//     */
//    public Customer putCustomerById(String id, Customer customer) throws BaseException {
//        logger.info("update customer service");
//        if (postgreRepository.getMemberAvailability(id.trim(), "Customer")) {
//            try {
//                JSONObject dtoJson = jsonConverter.convertToJSON(customer);
//                postgreRepository.update(postgrePutQueryGenerator.generatePutEntityQuery(dtoJson, id.trim(), "Customer"));
//                return customer;
//            } catch (Exception ex) {
//                logger.error("error in customer updating " + ExceptionUtils.getStackTrace(ex));
//                throw new BaseException(ex.getClass().getName(), "error in customer updating", "500", HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            logger.info("No Customer found");
//            throw new BaseException("Not found", "No customer found", "404", HttpStatus.NOT_FOUND);
//        }
//    }
//}
