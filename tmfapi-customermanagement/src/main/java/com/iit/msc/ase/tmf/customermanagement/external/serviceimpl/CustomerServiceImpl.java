package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CustomerRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.TimePeriodRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.TimePeriodService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.TimePeriod;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer create(CustomerDto customerDto) {
        log("create method of Customer started");

        Customer customer = getModelMapper().map(customerDto, Customer.class);

        return customerRepository.save(customer);
    }

    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
