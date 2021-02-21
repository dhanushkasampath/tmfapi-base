package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.RelatedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface RelatedPartyRefService extends CommonService {

    RelatedParty create(RelatedParty relatedParty);

    List < RelatedParty > findByReferredType(String referredType);

}
