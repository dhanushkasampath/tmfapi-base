package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CharacteristicRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CharacteristicService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Characteristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class CharacteristicServiceImpl implements CharacteristicService {

    @Autowired
    private CharacteristicRepository characteristicRepository;

    @Override
    public Characteristic create(Characteristic characteristic) {
        log("create method of Characteristic started");
        return characteristicRepository.save(characteristic);
    }

}
