package com.iit.msc.ase.tmf.productordering.domain.service.productorder;

import java.util.logging.Logger;

import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductOrderService {
    private static final Logger logger = Logger.getLogger(DeleteProductOrderService.class.getName());

//    @Autowired
//    PostgreRepository postgreRepository;
//    @Autowired
//    @Qualifier("postgre")
//    QueryGeneratorInterface queryGeneratorInterface;

    public void deleteProductOrderById(String id) throws BaseException {
        logger.info("Delete Product Order Service");
        try {
//            String query = queryGeneratorInterface.deletionQuery(id,"ProductOrder");
//            postgreRepository.delete(query);

        } catch (Exception ex) {
            logger.severe("error in product order deletion " + ExceptionUtils.getStackTrace(ex));
            throw new BaseException(ex.getClass().getName(), "error in product order deletion", "500", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
