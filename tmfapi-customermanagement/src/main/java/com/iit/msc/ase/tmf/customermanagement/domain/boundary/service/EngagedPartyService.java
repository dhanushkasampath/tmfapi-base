package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.EngagedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface EngagedPartyService extends CommonService {

    EngagedParty create(EngagedParty engagedParty);

    EngagedParty findById(String id);

}
