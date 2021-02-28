package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AgreementRef;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface AgreementRefService extends CommonService {

    AgreementRef create(AgreementRef agreementRef);

    AgreementRef findById(String id);

}
