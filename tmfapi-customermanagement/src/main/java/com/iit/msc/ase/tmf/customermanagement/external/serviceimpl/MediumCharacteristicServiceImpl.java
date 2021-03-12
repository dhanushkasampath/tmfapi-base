package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.MediumCharacteristicRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.MediumCharacteristicService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.MediumCharacteristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-21
 */
@Service
public class MediumCharacteristicServiceImpl implements MediumCharacteristicService {

    @Autowired
    private MediumCharacteristicRepository mediumCharacteristicRepository;

    @Override
    public MediumCharacteristic create(MediumCharacteristic mediumCharacteristic) {
        log("create method of MediumCharacteristic started");
        return mediumCharacteristicRepository.save(mediumCharacteristic);
    }

}
