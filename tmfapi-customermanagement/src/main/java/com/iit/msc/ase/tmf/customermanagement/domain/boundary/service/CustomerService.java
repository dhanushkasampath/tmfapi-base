package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.TimePeriod;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;

public interface CustomerService extends CommonService {

    Customer create(CustomerDto customerDto);
}
