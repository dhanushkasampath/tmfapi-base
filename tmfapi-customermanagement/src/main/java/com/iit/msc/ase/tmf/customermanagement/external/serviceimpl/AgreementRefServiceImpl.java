package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.Optional;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.AgreementRefRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AgreementRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.AgreementRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class AgreementRefServiceImpl implements AgreementRefService {

    @Autowired
    private AgreementRefRepository agreementRefRepository;

    @Override
    public AgreementRef create(AgreementRef agreementRef) {
        log("create method of AgreementRef started");
        return agreementRefRepository.save(agreementRef);
    }

    @Override
    public AgreementRef findById(String id) {
        log("findById method of AgreementRef started");
        Optional < AgreementRef > agreementRefOptional = agreementRefRepository.findById(id);
        return agreementRefOptional.orElse(null);
    }

}
