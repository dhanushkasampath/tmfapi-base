package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CreditProfileRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CreditProfileService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.CreditProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class CreditProfileServiceImpl implements CreditProfileService {

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    @Override
    public CreditProfile create(CreditProfile creditProfile) {
        log("create method of CreditProfile started");
        return creditProfileRepository.save(creditProfile);
    }

    @Override
    public List < CreditProfile > findByType(String type) {
        log("findByType method of CreditProfile started");
        return creditProfileRepository.findByType(type);
    }

}
