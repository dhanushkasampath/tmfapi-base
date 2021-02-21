package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.CreditProfile;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface CreditProfileService extends CommonService {

    CreditProfile create(CreditProfile creditProfile);

//    List < AccountRef > findByReferredType(String referencedType);

}
