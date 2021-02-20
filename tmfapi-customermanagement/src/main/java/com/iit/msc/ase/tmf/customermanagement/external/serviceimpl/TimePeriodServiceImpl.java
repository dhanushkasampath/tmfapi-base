package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.TimePeriodRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.TimePeriodService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.TimePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan(basePackages = {"com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.TimePeriodRepository"})
@Service
public class TimePeriodServiceImpl implements TimePeriodService {

//    @Autowired
//    private TimePeriodRepository timePeriodRepository;

    @Override
    public TimePeriod create(TimePeriod timePeriod) {
        log("create method of TimePeriod started");
//        return timePeriodRepository.save(timePeriod);
        return null;
    }

}
