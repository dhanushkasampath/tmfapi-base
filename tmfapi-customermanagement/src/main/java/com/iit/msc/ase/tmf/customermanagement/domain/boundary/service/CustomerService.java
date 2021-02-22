package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;

public interface CustomerService extends CommonService {

    CreateCustomerRespDto create(CreateCustomerReqDto createCustomerReqDto);

}
