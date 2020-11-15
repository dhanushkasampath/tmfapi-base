package com.iit.msc.ase.tmf.productordering.domain.service.cancelproductorder;

import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.adl.et.telco.tmf.commonconfig.external.util.IdGenerator;
import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
import com.adl.et.telco.tmf.datamodel.domain.boundary.QueryGeneratorInterface;
import com.adl.et.telco.tmf.datamodel.external.repository.PostgreRepository;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CancelProductOrder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateCancelProductOrderService {
    private static final Logger logger = Logger.getLogger(CreateCancelProductOrderService.class.getName());
    @Autowired
    JSONConverter jsonConverter;

    @Autowired
    IdGenerator idGenerator;

    @Autowired
    @Qualifier("postgre")
    QueryGeneratorInterface queryGeneratorInterface;

    @Autowired
    PostgreRepository postgreRepository;

    public CancelProductOrder createCancelProductOrder(CancelProductOrder cancelProductOrder) throws BaseException {
        logger.info("Create Cancel Product Order Service");

        try {
            String id = "";
            if (cancelProductOrder.getId() != null){
                id = cancelProductOrder.getId();
            } else {
                id = idGenerator.generate();
            }
            String query = queryGeneratorInterface.insertionQuery(jsonConverter.convertToJSON(cancelProductOrder), id, "CancelProductOrder");
            postgreRepository.insert(query);
            return cancelProductOrder;
        } catch (Exception ex) {
            logger.severe("error in cancel product order creation " + ExceptionUtils.getStackTrace(ex));
            throw new BaseException(ex.getClass().getName(), "error in cancel product order creation", "500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
