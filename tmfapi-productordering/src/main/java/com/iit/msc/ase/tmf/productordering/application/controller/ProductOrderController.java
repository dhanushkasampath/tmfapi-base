package com.iit.msc.ase.tmf.productordering.application.controller;

import com.adl.et.telco.tmf.commonconfig.application.controller.BaseController;
import com.adl.et.telco.tmf.commonconfig.application.exception.type.BaseException;
import com.iit.msc.ase.tmf.datamodel.domain.responses.ErrorResponse;
import com.iit.msc.ase.tmf.productordering.domain.service.productorder.CreateProductOrderService;
import com.iit.msc.ase.tmf.productordering.domain.service.productorder.DeleteProductOrderService;
import com.iit.msc.ase.tmf.productordering.domain.service.productorder.GetProductOrderService;
import com.iit.msc.ase.tmf.productordering.domain.service.productorder.UpdateProductOrderService;
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

import com.iit.msc.ase.tmf.datamodel.domain.dto.ProductOrder;

@RestController
@RequestMapping(value = "/tmf-api/productOrderingManagement/v4/productOrder")
public class ProductOrderController extends BaseController {

    private static final Logger logger = Logger.getLogger(ProductOrderController.class.getName());
    @Autowired
    CreateProductOrderService createProductOrderService;

    @Autowired
    DeleteProductOrderService deleteProductOrderService;

    @Autowired
    GetProductOrderService getProductOrderService;

    @Autowired
    UpdateProductOrderService updateProductOrderService;


    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = ProductOrder.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
        @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createProductOrder(@Valid @RequestBody(required=true) ProductOrder productOrder, HttpServletRequest request) throws BaseException {
        logger.info("Create product order");
        return ResponseEntity.status(HttpStatus.OK).body(createProductOrderService.createProductOrder(productOrder));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated", response = ProductOrder.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @PatchMapping(value = "/{id}", consumes = "APPLICATION/MERGE-PATCH+JSON", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProductOrderById(@PathVariable("id") String id, @RequestBody ProductOrder productOrder, HttpServletRequest request) throws BaseException {
        logger.info("update product order by id");
        return ResponseEntity.status(HttpStatus.OK).body(updateProductOrderService.updateProductOrderById(id, productOrder));
    }


    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleted"),
            @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized",response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden",response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found",response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed",response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict",response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error",response = ErrorResponse.class)
    })
    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteProductOrderById(@PathVariable("id") String id,HttpServletRequest request) throws BaseException {
        logger.info("delete product order by id");
        deleteProductOrderService.deleteProductOrderById(id);
        return ResponseEntity.status(204).body("");
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ProductOrder.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProductOrders(@ApiParam(hidden = false) @RequestParam(required = false) Map<String, String> filters, @RequestParam(required = false) String fields, @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit, HttpServletRequest request) throws BaseException {
        logger.info("get all product orders");
        return ResponseEntity.status(HttpStatus.OK).body(getProductOrderService.getAllProductOrders(fields, offset, limit, filters));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ProductOrder.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
            @ApiResponse(code = 405, message = "Method Not allowed", response = ErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductOrderById(@ApiParam(hidden = false) @RequestParam(required = false) Map<String, String> filters,@PathVariable("id") String id, @RequestParam(required = false) String fields, HttpServletRequest request) throws BaseException {
        logger.info("get product order by id");
        return ResponseEntity.status(HttpStatus.OK).body(getProductOrderService.getProductOrderById(id, fields,filters));
    }
}
