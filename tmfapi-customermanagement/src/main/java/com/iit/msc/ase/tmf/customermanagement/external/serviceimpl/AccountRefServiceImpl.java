package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.AccountRefRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AccountRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRefServiceImpl implements AccountRefService {

    @Autowired
    private AccountRefRepository accountRefRepository;

    @Override
    public AccountRef create(AccountRef accountRef) {
        log("create method of AccountRef started");
        return accountRefRepository.save(accountRef);
    }

    @Override
    public List < AccountRef > findByReferredType(String referencedType) {
        log("findByReferredType method of AccountRef started|referencedType:{}", referencedType);
        return accountRefRepository.findByReferredType(referencedType);
    }

}
