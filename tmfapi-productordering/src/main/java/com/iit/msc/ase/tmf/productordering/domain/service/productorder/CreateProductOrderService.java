package com.iit.msc.ase.tmf.productordering.domain.service.productorder;

import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.adl.et.telco.tmf.commonconfig.external.util.IdGenerator;
import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
import com.adl.et.telco.tmf.datamodel.domain.boundary.QueryGeneratorInterface;
import com.adl.et.telco.tmf.datamodel.domain.dto.ProductOrder;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateProductOrderService {
    private static final Logger logger = Logger.getLogger(CreateProductOrderService.class.getName());
    @Autowired
    JSONConverter jsonConverter;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    @Qualifier("postgre")
    QueryGeneratorInterface queryGeneratorInterface;

    @Autowired
    PostgreRepository postgreRepository;

    public ProductOrder createProductOrder(com.iit.msc.ase.tmf.datamodel.domain.dto.ProductOrder productOrder) throws BaseException {
        logger.info("Create Product Order Service");

        try {
            String id = "";
            if (productOrder.getId() != null){
                id = productOrder.getId();
            } else {
                id = idGenerator.generate();
            }
            String query = queryGeneratorInterface.insertionQuery(jsonConverter.convertToJSON(productOrder), id, "ProductOrder");
            postgreRepository.insert(query);
            return productOrder;
        } catch (Exception ex) {
            logger.severe("error in product order creation " + ExceptionUtils.getStackTrace(ex));
            throw new BaseException(ex.getClass().getName(), "error in product order creation", "500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
