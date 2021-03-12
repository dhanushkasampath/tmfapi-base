package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.CreditProfile;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface CreditProfileService extends CommonService {

    CreditProfile create(CreditProfile creditProfile);

    List < CreditProfile > findByType(String type);

}
