package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.TimePeriod;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface TimePeriodService extends CommonService {

    TimePeriod create(TimePeriod timePeriod);
}
