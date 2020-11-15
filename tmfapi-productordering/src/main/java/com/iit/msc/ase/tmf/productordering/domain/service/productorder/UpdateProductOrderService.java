package com.iit.msc.ase.tmf.productordering.domain.service.productorder;

import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
import com.adl.et.telco.tmf.datamodel.domain.boundary.QueryGeneratorInterface;

import com.adl.et.telco.tmf.datamodel.external.repository.PostgreRepository;
import com.iit.msc.ase.tmf.datamodel.domain.dto.ProductOrder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UpdateProductOrderService {
    private static final Logger logger = Logger.getLogger(UpdateProductOrderService.class.getName());

    @Autowired
    JSONConverter jsonConverter;
    @Autowired
    PostgreRepository postgreRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("postgre")
    QueryGeneratorInterface queryGeneratorInterface;

    public ProductOrder updateProductOrderById(String id, ProductOrder productOrder) throws BaseException {
        logger.info("Update Product Order Service");
        if (postgreRepository.getMemberAvailability(id, "ProductOrder")) {
            try {
                String query = queryGeneratorInterface.updationQuery(jsonConverter.convertToJSON(productOrder), id, "ProductOrder");
                postgreRepository.update(query);
                return productOrder;
            } catch (Exception ex) {
                logger.severe("error in product order updating " + ExceptionUtils.getStackTrace(ex));
                throw new BaseException(ex.getClass().getName(), "error in product order updating", "500", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            logger.info("No product order found");
            throw new BaseException("Not found", "No product order found", "404", HttpStatus.NOT_FOUND);
        }
    }
}
