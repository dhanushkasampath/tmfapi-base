package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.MediumCharacteristic;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface MediumCharacteristicService extends CommonService {

    MediumCharacteristic create(MediumCharacteristic mediumCharacteristic);

//    List < MediumCharacteristic > findByReferredType(String referencedType);

}
