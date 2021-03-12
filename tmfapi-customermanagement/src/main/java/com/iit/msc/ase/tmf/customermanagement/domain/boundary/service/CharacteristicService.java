package com.iit.msc.ase.tmf.customermanagement.domain.boundary.service;

import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.Characteristic;
import com.iit.msc.ase.tmf.customermanagement.domain.service.CommonService;

public interface CharacteristicService extends CommonService {

    Characteristic create(Characteristic characteristic);

    List < Characteristic > findByName(String name);

}
