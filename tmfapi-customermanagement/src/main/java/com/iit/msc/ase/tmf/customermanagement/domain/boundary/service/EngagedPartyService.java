package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.EngagedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface EngagedPartyService extends CommonService {

    EngagedParty create(EngagedParty engagedParty);

//    List < EngagedParty > findByReferredType(String referencedType);

}
