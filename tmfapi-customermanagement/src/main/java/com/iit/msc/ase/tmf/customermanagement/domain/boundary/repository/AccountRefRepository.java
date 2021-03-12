package com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.AccountRef;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Repository
public interface AccountRefRepository extends MongoRepository < AccountRef, String > {

    List < AccountRef > findByReferredType(String referredType);


}
