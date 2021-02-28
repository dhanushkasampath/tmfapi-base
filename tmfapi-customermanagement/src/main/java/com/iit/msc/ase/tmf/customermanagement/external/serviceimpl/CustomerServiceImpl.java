package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CustomerRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AccountRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.AgreementRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CharacteristicService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.ContactMediumService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CreditProfileService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.EngagedPartyService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.PaymentRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.RelatedPartyRefService;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryAllCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryCustomerByIdRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.headers.ResponseHeaderDto;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.AgreementRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Characteristic;
import com.iit.msc.ase.tmf.customermanagement.domain.model.ContactMedium;
import com.iit.msc.ase.tmf.customermanagement.domain.model.CreditProfile;
import com.iit.msc.ase.tmf.customermanagement.domain.model.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.EngagedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.model.PaymentRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.RelatedParty;
import com.iit.msc.ase.tmf.customermanagement.external.util.Constants;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AccountRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AgreementRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CharacteristicDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.ContactMediumDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CreditProfileDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.EngagedPartyDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.PaymentRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.RelatedPartyDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private CreditProfileService creditProfileService;

    @Autowired
    private ContactMediumService contactMediumService;

    @Autowired
    private EngagedPartyService engagedPartyService;

    @Override
    public CreateCustomerRespDto create(CreateCustomerReqDto createCustomerReqDto) {
        log("create method of Customer started");
        Customer customer = getModelMapper().map(createCustomerReqDto.getCustomer(), Customer.class);//mapping basic parameters

        customer.setAccount(getAccountRefsList(createCustomerReqDto.getCustomer()));
        customer.setAgreement(getAgreementRefsList(createCustomerReqDto.getCustomer()));
        customer.setCharacteristic(getCharacteristicsList(createCustomerReqDto.getCustomer()));
        customer.setPaymentMethod(getPaymentMethodList(createCustomerReqDto.getCustomer()));
        customer.setRelatedParty(getRelatedPartiesList(createCustomerReqDto.getCustomer()));
        customer.setCreditProfile(getCreditProfileList(createCustomerReqDto.getCustomer()));
        customer.setContactMedium(getContactMediumList(createCustomerReqDto.getCustomer()));
        customer.setEngagedParty(getEngagedPartyList(createCustomerReqDto.getCustomer()));

        CreateCustomerRespDto createCustomerRespDto = new CreateCustomerRespDto();
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        Customer createdCustomer = customerRepository.save(customer);
        if ( createdCustomer != null ) {
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
            responseHeaderDto.setResponseDesc("Operation successful");
            responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);
        }

        responseHeaderDto.setRequestId(createCustomerReqDto.getRequestHeader().getRequestId());
        responseHeaderDto.setTimestamp(LocalDateTime.now().toString());
        createCustomerRespDto.setResponseHeader(responseHeaderDto);
        log("create method of Customer ended");
        return createCustomerRespDto;
    }

    @Override
    public QueryAllCustomerRespDto queryAll() {
        log("queryAll method of Customer started");
        QueryAllCustomerRespDto queryAllCustomerRespDto = new QueryAllCustomerRespDto();
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        List < Customer > customerList = customerRepository.findAll();
        if(!customerList.isEmpty()){
            queryAllCustomerRespDto.setResponseData(customerList);
            responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
            responseHeaderDto.setResponseDesc("Operation successful");
        }else{
            responseHeaderDto.setResponseDescDisplay(Constants.CXM2000);
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
            responseHeaderDto.setResponseDesc("No records found");
        }

        responseHeaderDto.setTimestamp(LocalDateTime.now().toString());
        responseHeaderDto.setRequestId("123");
        queryAllCustomerRespDto.setResponseHeader(responseHeaderDto);
        log("queryAll method of Customer ended");
        return queryAllCustomerRespDto;
    }

    @Override
    public QueryCustomerByIdRespDto queryById(String id) {
        log("queryById method of Customer started|id:{}", id);
        QueryCustomerByIdRespDto queryCustomerByIdRespDto = new QueryCustomerByIdRespDto();
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        Optional < Customer > customer = customerRepository.findById(id);
        if(customer.isPresent()){
            queryCustomerByIdRespDto.setResponseData(customer.get());
            responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
            responseHeaderDto.setResponseDesc("Operation successful");
        }else{
            responseHeaderDto.setResponseDescDisplay(Constants.CXM2000);
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
            responseHeaderDto.setResponseDesc("Customer not found");
        }
        responseHeaderDto.setTimestamp(LocalDateTime.now().toString());
        responseHeaderDto.setRequestId("123");
        queryCustomerByIdRespDto.setResponseHeader(responseHeaderDto);
        log("queryById method of Customer ended");
        return queryCustomerByIdRespDto;
    }

    @Override
    public void deleteById(String id) {
        log("deleteById method of Customer started|id:{}", id);
        customerRepository.deleteById(id);
        log("deleteById method of Customer ended");

    }

    private List < EngagedParty > getEngagedPartyList(CustomerDto customerDto) {
        List < EngagedPartyDto > engagedPartyDtoList = customerDto.getEngagedParty();
        List < EngagedParty > engagedPartyList = new ArrayList <>();
        for ( EngagedPartyDto engagedPartyDto : engagedPartyDtoList ) {
            //find by @ReferredType
            List < EngagedParty > existingEngagedPartyList = engagedPartyService.findByReferredType(engagedPartyDto.getReferredType());
            if ( existingEngagedPartyList != null ) {
                if ( !existingEngagedPartyList.isEmpty() ) {
                    engagedPartyList.add(existingEngagedPartyList.get(0));
                } else {
                    engagedPartyList.add(engagedPartyService.create(getModelMapper().map(engagedPartyDto, EngagedParty.class)));
                }
            } else {
                //create a new record and add to list
                engagedPartyList.add(engagedPartyService.create(getModelMapper().map(engagedPartyDto, EngagedParty.class)));
            }
        }
        return engagedPartyList;
    }

    private List < ContactMedium > getContactMediumList(CustomerDto customerDto) {
        List < ContactMediumDto > contactMediumDtoList = customerDto.getContactMedium();
        List < ContactMedium > contactMediumList = new ArrayList <>();
        for ( ContactMediumDto contactMediumDto : contactMediumDtoList ) {
            //find by @Type
            List < ContactMedium > existingContactMediumList = contactMediumService.findByReferredType(contactMediumDto.getReferredType());
            if ( existingContactMediumList != null ) {
                if ( !existingContactMediumList.isEmpty() ) {
                    contactMediumList.add(existingContactMediumList.get(0));
                } else {
                    contactMediumList.add(contactMediumService.create(getModelMapper().map(contactMediumDto, ContactMedium.class)));
                }
            } else {
                //create a new record and add to list
                contactMediumList.add(contactMediumService.create(getModelMapper().map(contactMediumDto, ContactMedium.class)));
            }
        }
        return contactMediumList;
    }

    private List < CreditProfile > getCreditProfileList(CustomerDto customerDto) {
        List < CreditProfileDto > creditProfileDtoList = customerDto.getCreditProfile();
        List < CreditProfile > creditProfileList = new ArrayList <>();
        for ( CreditProfileDto creditProfileDto : creditProfileDtoList ) {
            //find by @Type
            List < CreditProfile > existingCreditProfileList = creditProfileService.findByType(creditProfileDto.getType());
            if ( existingCreditProfileList != null ) {
                if ( !existingCreditProfileList.isEmpty() ) {
                    creditProfileList.add(existingCreditProfileList.get(0));
                } else {
                    creditProfileList.add(creditProfileService.create(getModelMapper().map(creditProfileDto, CreditProfile.class)));
                }
            } else {
                //create a new record and add to list
                creditProfileList.add(creditProfileService.create(getModelMapper().map(creditProfileDto, CreditProfile.class)));
            }
        }
        return creditProfileList;
    }

    private List < PaymentRef > getPaymentMethodList(CustomerDto customerDto) {
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

    private List < AccountRef > getAccountRefsList(CustomerDto customerDto) {
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

    private List < AgreementRef > getAgreementRefsList(CustomerDto customerDto) {
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

    private List < Characteristic > getCharacteristicsList(CustomerDto customerDto) {
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

    private List < RelatedParty > getRelatedPartiesList(CustomerDto customerDto) {
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
