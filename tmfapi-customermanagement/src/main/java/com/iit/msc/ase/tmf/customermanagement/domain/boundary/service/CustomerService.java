package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.Map;

import com.iit.msc.ase.tmf.commonconfig.application.exception.type.CustomerMgtException;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryAllCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryCustomerByIdRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface CustomerService extends CommonService {

    CreateCustomerRespDto create(CreateCustomerReqDto createCustomerReqDto);

    QueryAllCustomerRespDto queryAll(Map < String, String > filters, String fields, Integer offset, Integer limit) throws CustomerMgtException;

    QueryCustomerByIdRespDto queryById(String id);

    void deleteById(String id);

    UpdateCustomerRespDto update(String id, UpdateCustomerReqDto updateCustomerReqDto);

    Customer findById(String id);
}
