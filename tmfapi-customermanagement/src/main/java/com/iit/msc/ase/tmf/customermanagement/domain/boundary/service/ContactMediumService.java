package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.ContactMedium;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface ContactMediumService extends CommonService {

    ContactMedium create(ContactMedium contactMedium);

    List < ContactMedium > findByReferredType(String referredType);

}
