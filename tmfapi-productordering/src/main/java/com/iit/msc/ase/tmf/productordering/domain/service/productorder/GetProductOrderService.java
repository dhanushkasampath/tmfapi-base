package com.iit.msc.ase.tmf.productordering.domain.service.productorder;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
import com.iit.msc.ase.tmf.datamodel.domain.dto.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProductOrderService {
    private static final Logger logger = Logger.getLogger(GetProductOrderService.class.getName());
//    @Autowired
//    JSONConverter jsonConverter;
//    @Autowired
//    @Qualifier("postgreEntityGenerator")
//    EntityGeneratorInterface entityGeneratorInterface;

    public List< ProductOrder > getAllProductOrders(String fields, Integer offset, Integer limit, Map<String, String> filters) throws BaseException {
        logger.info("Get All Product Orders");
    //    return jsonConverter.convertToObjectList(entityGeneratorInterface.generateResponseJSON("ProductOrder", filters, ""), "ProductOrder");
            return null;
    }

    public ProductOrder getProductOrderById(String id, String fields, Map<String, String> filters) throws BaseException {
        logger.info("Get Product Order By Id");
    //    return (ProductOrder) jsonConverter.convertToObject(entityGeneratorInterface.generateResponseJSON("ProductOrder", filters, id).getJSONObject(0), "ProductOrder");
        return null;
    }
}
