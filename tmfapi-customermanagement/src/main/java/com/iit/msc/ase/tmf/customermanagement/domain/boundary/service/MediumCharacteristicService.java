package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.MediumCharacteristic;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface MediumCharacteristicService extends CommonService {

    MediumCharacteristic create(MediumCharacteristic mediumCharacteristic);

//    List < MediumCharacteristic > findByReferredType(String referencedType);

}
