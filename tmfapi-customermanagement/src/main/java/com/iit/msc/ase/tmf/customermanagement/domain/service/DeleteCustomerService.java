///**
// * © Copyrights 2020 Axiata Digital Labs Pvt Ltd.
// * All Rights Reserved.
// * <p>
// * These material are unpublished, proprietary, confidential source
// * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
// * SECRET of ADL.
// * <p>
// * ADL retains all title to and intelectual property rights in these
// * materials.
// */
//
//package com.adl.et.telco.tmf.customermanagement.domain.service.customer;
//
//
//import com.adl.et.telco.dte.plugin.log.services.LoggingUtils;
//import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
//import com.adl.et.telco.tmf.datamodel.domain.boundary.QueryGeneratorInterface;
//import com.adl.et.telco.tmf.datamodel.external.repository.PostgreRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import ch.qos.logback.classic.Logger;
//
///**
// * <h1>Delete Service class for Customer!</h1>
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
//public class DeleteCustomerService {
//    private static final Logger logger = LoggingUtils.getLogger(DeleteCustomerService.class.getName());
//
//    @Autowired
//    @Qualifier("postgre")
//    QueryGeneratorInterface queryGeneratorInterface;
//    @Autowired
//    PostgreRepository postgreRepository;
//
//    /**
//     * Deletion of a customer entity from the repository
//     * @param id This is the first parameter: id of the customer entity
//     * @throws BaseException
//     */
//    public void deleteCustomerById(String id) throws BaseException {
//        logger.info("Delete Customer Service");
//        if (postgreRepository.getMemberAvailability(id, "Customer")) {
//            String query = queryGeneratorInterface.deletionQuery(id, "Customer");
//            postgreRepository.delete(query);
//        } else {
//            throw new BaseException("Not found", "No Customer Found", "404", HttpStatus.NOT_FOUND);
//
//        }
//    }
//}
