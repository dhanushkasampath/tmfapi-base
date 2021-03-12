package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.RelatedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface RelatedPartyRefService extends CommonService {

    RelatedParty create(RelatedParty relatedParty);

    RelatedParty findById(String referredType);

}
