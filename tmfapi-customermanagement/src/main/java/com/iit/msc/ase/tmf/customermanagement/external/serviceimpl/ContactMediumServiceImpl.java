package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.ContactMediumRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.ContactMediumService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.ContactMedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class ContactMediumServiceImpl implements ContactMediumService {

    @Autowired
    private ContactMediumRepository contactMediumRepository;

    @Override
    public ContactMedium create(ContactMedium contactMedium) {
        log("create method of ContactMedium started");
        return contactMediumRepository.save(contactMedium);
    }

    @Override
    public List < ContactMedium > findByReferredType(String referredType) {
        log("findByReferredType method of ContactMedium started");
        return contactMediumRepository.findByReferredType(referredType);
    }

}
