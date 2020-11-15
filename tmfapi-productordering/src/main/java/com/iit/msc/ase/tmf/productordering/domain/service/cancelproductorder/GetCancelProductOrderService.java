package com.iit.msc.ase.tmf.productordering.domain.service.cancelproductorder;

import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.adl.et.telco.tmf.commonconfig.external.util.JSONConverter;
import com.adl.et.telco.tmf.datamodel.domain.boundary.EntityGeneratorInterface;
import com.adl.et.telco.tmf.datamodel.domain.dto.CancelProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class GetCancelProductOrderService {
    private static final Logger logger = Logger.getLogger(GetCancelProductOrderService.class.getName());
    @Autowired
    JSONConverter jsonConverter;
    @Autowired
    @Qualifier("postgreEntityGenerator")
    EntityGeneratorInterface entityGeneratorInterface;

    public List<CancelProductOrder> getAllCancelProductOrders(String fields, Integer offset, Integer limit, Map<String, String> filters) throws BaseException {
        logger.info("Get All Cancel Product Orders");
        return jsonConverter.convertToObjectList(entityGeneratorInterface.generateResponseJSON("CancelProductOrder", filters, ""), "CancelProductOrder");

    }

    public CancelProductOrder getCancelProductOrderById(String id, String fields, Map<String, String> filters) throws BaseException {
        logger.info("Get Cancel Product Order By Id");
        return (CancelProductOrder) jsonConverter.convertToObject(entityGeneratorInterface.generateResponseJSON("CancelProductOrder", filters, id).getJSONObject(0), "CancelProductOrder");

    }
}
