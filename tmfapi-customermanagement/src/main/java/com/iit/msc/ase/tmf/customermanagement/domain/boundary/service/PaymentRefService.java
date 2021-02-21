package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.PaymentRef;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface PaymentRefService extends CommonService {

    PaymentRef create(PaymentRef paymentRef);

    List < PaymentRef > findByReferredType(String referredType);

}
