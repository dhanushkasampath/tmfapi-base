package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryAllCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryCustomerByIdRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface CustomerService extends CommonService {

    CreateCustomerRespDto create(CreateCustomerReqDto createCustomerReqDto);

    QueryAllCustomerRespDto queryAll();

    QueryCustomerByIdRespDto queryById(String id);

    void deleteById(String id);

}
