package com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Repository
public interface CustomerRepository extends MongoRepository < Customer, String > {

    //need to research on this
//    @Query(value="{\"contactMedium.characteristic.emailAddress\":\"alain.delon@best-actor.fr\"}")//json can be passed as value  @Query(value="{}", fields="{name : 1, _id : 0}")
//    @Query(value="{\"type\":\"Customer\"}")//json can be passed as value  @Query(value="{}", fields="{name : 1, _id : 0}")
//    List < Customer > findByFilters(Pageable requestedPage);

}