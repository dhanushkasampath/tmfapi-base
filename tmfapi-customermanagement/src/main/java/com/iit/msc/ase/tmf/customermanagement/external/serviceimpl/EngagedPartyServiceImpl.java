package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.EngagedPartyRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.EngagedPartyService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.EngagedParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class EngagedPartyServiceImpl implements EngagedPartyService {

    @Autowired
    private EngagedPartyRepository engagedPartyRepository;

    @Override
    public EngagedParty create(EngagedParty engagedParty) {
        log("create method of EngagedParty started");
        return engagedPartyRepository.save(engagedParty);
    }

}
