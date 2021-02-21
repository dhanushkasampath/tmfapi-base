package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.RelatedPartyRefRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.RelatedPartyRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.RelatedParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class RelatedPartyRefServiceImpl implements RelatedPartyRefService {

    @Autowired
    private RelatedPartyRefRepository relatedPartyRefRepository;

    @Override
    public RelatedParty create(RelatedParty relatedParty) {
        log("create method of RelatedParty started");
        return relatedPartyRefRepository.save(relatedParty);
    }

    @Override
    public List < RelatedParty > findByReferredType(String referredType) {
        return relatedPartyRefRepository.findByReferredType(referredType);
    }

}
