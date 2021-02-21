package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.AccountRefRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CustomerRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.TimePeriodRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AccountRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.TimePeriodService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AgreementRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.TimePeriod;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AccountRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AgreementRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRefService accountRefService;

    @Override
    public Customer create(CustomerDto customerDto) {
        log("create method of Customer started");

        Customer customer = getModelMapper().map(customerDto, Customer.class);

        List < AccountRefDto > accountRefDtoList = customerDto.getAccount();
        List < AccountRef > accountRefList = new ArrayList <>();
        for ( AccountRefDto accountRefDto : accountRefDtoList ) {
            //find by @referrencedType
            List < AccountRef > existingAccountRefList = accountRefService.findByReferredType(accountRefDto.getReferredType());
            if ( existingAccountRefList != null ) {
                if(!existingAccountRefList.isEmpty()){
                    accountRefList.add(existingAccountRefList.get(0));
                }else{
                    accountRefList.add(accountRefService.create(getModelMapper().map(accountRefDto, AccountRef.class)));
                }
            }else{
                //create a new record and add to list
                accountRefList.add(accountRefService.create(getModelMapper().map(accountRefDto, AccountRef.class)));
            }
        }
        customer.setAccount(accountRefList);

//        List < AgreementRefDto > agreementRefDtoList = customerDto.getAgreement();
//        List < AgreementRef > agreementRef = new ArrayList <>();
//        for ( AgreementRefDto accountRefDto : agreementRefDtoList ) {
//            //find by @referrencedType
//            List < AccountRef > existingAccountRefList = accountRefRepository.findByReferredType(accountRefDto.getReferredType());
//            if ( existingAccountRefList != null ) {
//                if(!existingAccountRefList.isEmpty()){
//                    accountRefList.add(existingAccountRefList.get(0));
//                }else{
//                    accountRefList.add(accountRefService.create(getModelMapper().map(accountRefDto, AccountRef.class)));
//                }
//            }else{
//                //create a new record and add to list
//                accountRefList.add(accountRefService.create(getModelMapper().map(accountRefDto, AccountRef.class)));
//            }
//        }
        customer.setAgreement(null);
        customer.setCharacteristic(null);
        customer.setContactMedium(null);
        customer.setCreditProfile(null);
        customer.setPaymentMethod(null);
        customer.setRelatedParty(null);
        customer.setValidFor(null);
        return customerRepository.save(customer);
    }

    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
