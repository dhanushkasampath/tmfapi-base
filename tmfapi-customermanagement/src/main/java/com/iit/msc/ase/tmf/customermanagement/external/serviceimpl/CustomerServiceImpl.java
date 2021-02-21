package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CustomerRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AccountRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AgreementRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CharacteristicService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.PaymentRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.RelatedPartyRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AgreementRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Characteristic;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.PaymentRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.RelatedParty;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AccountRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AgreementRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CharacteristicDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.PaymentRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.RelatedPartyDto;
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

    @Autowired
    private AgreementRefService agreementRefService;

    @Autowired
    private CharacteristicService characteristicService;

    @Autowired
    private RelatedPartyRefService relatedPartyRefService;

    @Autowired
    private PaymentRefService paymentRefService;

    @Override
    public Customer create(CustomerDto customerDto) {
        log("create method of Customer started");

        Customer customer = getModelMapper().map(customerDto, Customer.class);//mapping basic parameters

        customer.setAccount(getAccountRefs(customerDto));
        customer.setAgreement(getAgreementRefs(customerDto));
        customer.setCharacteristic(getCharacteristics(customerDto));
        customer.setPaymentMethod(getPaymentMethod(customerDto));
        customer.setRelatedParty(getRelatedParties(customerDto));

        customer.setContactMedium(null);
        customer.setCreditProfile(null);


        customer.setValidFor(null);
        return customerRepository.save(customer);
    }

    private List < PaymentRef > getPaymentMethod(CustomerDto customerDto) {
        List < PaymentRefDto > paymentRefDtoList = customerDto.getPaymentMethod();
        List < PaymentRef > paymentRefList = new ArrayList <>();
        for ( PaymentRefDto paymentRefDto : paymentRefDtoList ) {
            //find by @referredType
            List < PaymentRef > existingPaymentRefList = paymentRefService.findByReferredType(paymentRefDto.getReferredType());
            if ( existingPaymentRefList != null ) {
                if ( !existingPaymentRefList.isEmpty() ) {
                    paymentRefList.add(existingPaymentRefList.get(0));
                } else {
                    paymentRefList.add(paymentRefService.create(getModelMapper().map(paymentRefDto, PaymentRef.class)));
                }
            } else {
                //create a new record and add to list
                paymentRefList.add(paymentRefService.create(getModelMapper().map(paymentRefDto, PaymentRef.class)));
            }
        }
        return paymentRefList;
    }

    private List < AccountRef > getAccountRefs(CustomerDto customerDto) {
        List < AccountRefDto > accountRefDtoList = customerDto.getAccount();
        List < AccountRef > accountRefList = new ArrayList <>();
        for ( AccountRefDto accountRefDto : accountRefDtoList ) {
            //find by @referredType
            List < AccountRef > existingAccountRefList = accountRefService.findByReferredType(accountRefDto.getReferredType());
            if ( existingAccountRefList != null ) {
                if ( !existingAccountRefList.isEmpty() ) {
                    accountRefList.add(existingAccountRefList.get(0));
                } else {
                    accountRefList.add(accountRefService.create(getModelMapper().map(accountRefDto, AccountRef.class)));
                }
            } else {
                //create a new record and add to list
                accountRefList.add(accountRefService.create(getModelMapper().map(accountRefDto, AccountRef.class)));
            }
        }
        return accountRefList;
    }

    private List < AgreementRef > getAgreementRefs(CustomerDto customerDto) {
        List < AgreementRefDto > agreementRefDtoList = customerDto.getAgreement();
        List < AgreementRef > agreementRefList = new ArrayList <>();
        for ( AgreementRefDto agreementRefDto : agreementRefDtoList ) {
            //find by @referredType
            List < AgreementRef > existingAgreementRefList = agreementRefService.findByReferredType(agreementRefDto.getReferredType());
            if ( existingAgreementRefList != null ) {
                if ( !existingAgreementRefList.isEmpty() ) {
                    agreementRefList.add(existingAgreementRefList.get(0));
                } else {
                    agreementRefList.add(agreementRefService.create(getModelMapper().map(agreementRefDto, AgreementRef.class)));
                }
            } else {
                //create a new record and add to list
                agreementRefList.add(agreementRefService.create(getModelMapper().map(agreementRefDto, AgreementRef.class)));
            }
        }
        return agreementRefList;
    }

    private List < Characteristic > getCharacteristics(CustomerDto customerDto) {
        List < CharacteristicDto > characteristicDtoList = customerDto.getCharacteristic();
        List < Characteristic > characteristicList = new ArrayList <>();
        for ( CharacteristicDto characteristicDto : characteristicDtoList ) {
            //find by name
            List < Characteristic > existingCharacteristicList = characteristicService.findByName(characteristicDto.getName());
            if ( existingCharacteristicList != null ) {
                if ( !existingCharacteristicList.isEmpty() ) {
                    characteristicList.add(existingCharacteristicList.get(0));
                } else {
                    characteristicList.add(characteristicService.create(getModelMapper().map(characteristicDto, Characteristic.class)));
                }
            } else {
                //create a new record and add to list
                characteristicList.add(characteristicService.create(getModelMapper().map(characteristicDto, Characteristic.class)));
            }
        }
        return characteristicList;
    }

    private List < RelatedParty > getRelatedParties(CustomerDto customerDto) {
        List < RelatedPartyDto > relatedPartyDtoList = customerDto.getRelatedParty();
        List < RelatedParty > relatedPartyList = new ArrayList <>();
        for ( RelatedPartyDto relatedPartyDto : relatedPartyDtoList ) {
            //find by name
            List < RelatedParty > existingRelatedPartyList = relatedPartyRefService.findByReferredType(relatedPartyDto.getReferredType());
            if ( existingRelatedPartyList != null ) {
                if ( !existingRelatedPartyList.isEmpty() ) {
                    relatedPartyList.add(existingRelatedPartyList.get(0));
                } else {
                    relatedPartyList.add(relatedPartyRefService.create(getModelMapper().map(relatedPartyDto, RelatedParty.class)));
                }
            } else {
                //create a new record and add to list
                relatedPartyList.add(relatedPartyRefService.create(getModelMapper().map(relatedPartyDto, RelatedParty.class)));
            }
        }
        return relatedPartyList;
    }

    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
