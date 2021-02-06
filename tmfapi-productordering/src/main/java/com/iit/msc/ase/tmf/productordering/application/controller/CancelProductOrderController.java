package com.iit.msc.ase.tmf.productordering.application.controller;

import com.adl.et.telco.tmf.commonconfig.application.controller.BaseController;
import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CancelProductOrder;
import com.iit.msc.ase.tmf.datamodel.domain.responses.ErrorResponse;
import com.iit.msc.ase.tmf.productordering.domain.service.cancelproductorder.CreateCancelProductOrderService;
import com.iit.msc.ase.tmf.productordering.domain.service.cancelproductorder.GetCancelProductOrderService;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/tmf-api/productOrderingManagement/v4/cancelProductOrder")
public class CancelProductOrderController extends BaseController{
    private static final Logger logger = Logger.getLogger(CancelProductOrderController.class.getName());
    @Autowired
    CreateCancelProductOrderService createCancelProductOrderService;

    @Autowired
    GetCancelProductOrderService getCancelProductOrderService;

    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = CancelProductOrder.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCancelProductOrder(@Valid @RequestBody(required=true) CancelProductOrder cancelProductOrder, HttpServletRequest request) throws BaseException {
        logger.info("Create cancel product order");
        return ResponseEntity.status(HttpStatus.OK).body(createCancelProductOrderService.createCancelProductOrder(cancelProductOrder));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CancelProductOrder.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCancelProductOrders(@ApiParam(hidden = false) @RequestParam(required = false) Map<String, String> filters, @RequestParam(required = false) String fields, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit, HttpServletRequest request) throws BaseException {
        logger.info("get all cancel product orders");
        return ResponseEntity.status(HttpStatus.OK).body(getCancelProductOrderService.getAllCancelProductOrders(fields, offset, limit, filters));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CancelProductOrder.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCancelProductOrderById(@ApiParam(hidden = false) @RequestParam(required = false) Map<String, String> filters,@PathVariable("id") String id, @RequestParam(required = false) String fields, HttpServletRequest request) throws BaseException {
        logger.info("get cancel product order by id");
        return ResponseEntity.status(HttpStatus.OK).body(getCancelProductOrderService.getCancelProductOrderById(id, fields,filters));
    }


}
