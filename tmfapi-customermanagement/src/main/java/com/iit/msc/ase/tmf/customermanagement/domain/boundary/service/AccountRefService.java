package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface AccountRefService extends CommonService {

    AccountRef create(AccountRef accountRef);

    List < AccountRef > findByReferredType(String referencedType);

}
