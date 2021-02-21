package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AgreementRef;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface AgreementRefService extends CommonService {

    AgreementRef create(AgreementRef agreementRef);

    List < AgreementRef > findByReferredType(String referredType);

}
