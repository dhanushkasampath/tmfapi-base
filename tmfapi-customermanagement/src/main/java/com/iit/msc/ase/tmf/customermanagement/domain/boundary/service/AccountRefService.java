package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface AccountRefService extends CommonService {

    AccountRef create(AccountRef accountRef);

    AccountRef findById(String id);

}
