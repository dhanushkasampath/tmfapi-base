package com.iit.msc.ase.tmf.customermanagement.external.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.iit.msc.ase.tmf.commonconfig.application.exception.type.CustomerMgtException;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CustomerRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.service.CustomerService;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryAllCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryCustomerByIdRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.headers.ResponseHeaderDto;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.AgreementRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.Characteristic;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.ContactMedium;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.CreditProfile;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.EngagedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.PaymentRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.RelatedParty;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.TimePeriod;
import com.iit.msc.ase.tmf.customermanagement.external.util.Constants;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.skip;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Value( "${validation.regex.offset}" )
    private String validationRegexOffset;

    @Value( "${validation.regex.limit}" )
    private String validationRegexLimit;

    @Value( "${customer.href}" )
    private String customerHref;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CreateCustomerRespDto create(CreateCustomerReqDto createCustomerReqDto) {
        log("create method of Customer started");
        Customer customer = getModelMapper().map(createCustomerReqDto.getCustomer(), Customer.class);//mapping basic parameters

        customer.setAccount(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getAccount(), AccountRef[].class)));
        customer.setAgreement(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getAgreement(), AgreementRef[].class)));
        customer.setCharacteristic(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getCharacteristic(), Characteristic[].class)));
        customer.setPaymentMethod(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getPaymentMethod(), PaymentRef[].class)));
        customer.setRelatedParty(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getRelatedParty(), RelatedParty[].class)));
        customer.setCreditProfile(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getCreditProfile(), CreditProfile[].class)));
        customer.setContactMedium(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getContactMedium(), ContactMedium[].class)));
        customer.setEngagedParty(Arrays.asList(getModelMapper().map(createCustomerReqDto.getCustomer().getEngagedParty(), EngagedParty[].class)));

        CreateCustomerRespDto createCustomerRespDto = new CreateCustomerRespDto();
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        Customer createdCustomer = customerRepository.save(customer);
        createdCustomer.setHref(customerHref.replace(Constants.CUSTOMER_ID_IDENTIFIER, createdCustomer.getId()));
        customerRepository.save(createdCustomer);
        responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
        responseHeaderDto.setResponseDesc(Constants.OPERATION_SUCCESSFUL);
        responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);

        responseHeaderDto.setRequestId(createCustomerReqDto.getRequestHeader().getRequestId());
        responseHeaderDto.setTimestamp(LocalDateTime.now().toString());
        createCustomerRespDto.setResponseHeader(responseHeaderDto);
        log("create method of Customer ended");
        return createCustomerRespDto;
    }

    @Override
    public QueryAllCustomerRespDto queryAll(Map < String, String > filters, String fields, Integer offset, Integer limit) throws CustomerMgtException {
        log("queryAll method of Customer started");
        validateOffset(offset);
        validateLimit(limit);
        QueryAllCustomerRespDto queryAllCustomerRespDto = new QueryAllCustomerRespDto();
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        Pageable requestedPage = PageRequest.of(offset - 1, limit);
        List < Customer > customerList;
        customerList = findByFilters(filters, fields, requestedPage, offset, limit);
        if ( !customerList.isEmpty() ) {
            queryAllCustomerRespDto.setResponseData(customerList);
            responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
            responseHeaderDto.setResponseDesc(Constants.OPERATION_SUCCESSFUL);
        } else {
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
        if ( customer.isPresent() ) {
            queryCustomerByIdRespDto.setResponseData(customer.get());
            responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);
            responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
            responseHeaderDto.setResponseDesc(Constants.OPERATION_SUCCESSFUL);
        } else {
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

    @Override
    public UpdateCustomerRespDto update(String id, UpdateCustomerReqDto updateCustomerReqDto) {
        log("update method of Customer started");
        Customer customer = findById(id);
        customer.setStatus(updateCustomerReqDto.getCustomer().getStatus());
        customer.setType(updateCustomerReqDto.getCustomer().getType());
        customer.setStatusReason(updateCustomerReqDto.getCustomer().getStatusReason());
        customer.setBaseType(updateCustomerReqDto.getCustomer().getBaseType());
        customer.setName(updateCustomerReqDto.getCustomer().getName());
        customer.setSchemaLocation(updateCustomerReqDto.getCustomer().getSchemaLocation());
        customer.setValidFor(getModelMapper().map(updateCustomerReqDto.getCustomer().getValidFor(), TimePeriod.class));

        customer.setAccount(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getAccount(), AccountRef[].class)));
        customer.setAgreement(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getAgreement(), AgreementRef[].class)));
        customer.setCharacteristic(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getCharacteristic(), Characteristic[].class)));
        customer.setPaymentMethod(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getPaymentMethod(), PaymentRef[].class)));
        customer.setRelatedParty(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getRelatedParty(), RelatedParty[].class)));
        customer.setCreditProfile(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getCreditProfile(), CreditProfile[].class)));
        customer.setContactMedium(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getContactMedium(), ContactMedium[].class)));
        customer.setEngagedParty(Arrays.asList(getModelMapper().map(updateCustomerReqDto.getCustomer().getEngagedParty(), EngagedParty[].class)));

        UpdateCustomerRespDto updateCustomerRespDto = new UpdateCustomerRespDto();
        ResponseHeaderDto responseHeaderDto = new ResponseHeaderDto();
        customerRepository.save(customer);
        responseHeaderDto.setResponseCode(String.valueOf(HttpStatus.OK.value()));
        responseHeaderDto.setResponseDesc(Constants.OPERATION_SUCCESSFUL);
        responseHeaderDto.setResponseDescDisplay(Constants.CXM1000);

        responseHeaderDto.setRequestId(updateCustomerReqDto.getRequestHeader().getRequestId());
        responseHeaderDto.setTimestamp(LocalDateTime.now().toString());
        updateCustomerRespDto.setResponseHeader(responseHeaderDto);
        log("create method of Customer ended");
        return updateCustomerRespDto;
    }

    @Override
    public Customer findById(String id) {
        log("findByReferredType method of EngagedParty started");
        Optional < Customer > customerOptional = customerRepository.findById(id);
        return customerOptional.orElse(null);
    }

    /**
     * @param limit
     * @throws CustomerMgtException
     */
    private void validateLimit(Integer limit) throws CustomerMgtException {
        if ( !Pattern.matches(validationRegexLimit, limit.toString()) || limit <= 0 ) {
            logger.error("Invalid limit:{}", limit);
            throw new CustomerMgtException(String.format("Invalid limit:%s", limit), Constants.CXM2002);
        }
    }

    /**
     * @param offset
     * @throws CustomerMgtException
     */
    private void validateOffset(Integer offset) throws CustomerMgtException {
        if ( !Pattern.matches(validationRegexOffset, offset.toString()) || offset <= 0 ) {
            logger.error("Invalid offset:{}", offset);
            throw new CustomerMgtException(String.format("Invalid offset:%s", offset), Constants.CXM2001);
        }
    }

    /**
     * @param filters
     * @param fields
     * @param requestedPage
     * @param pageNumber
     * @param pageSize
     * @return
     */
    private List < Customer > findByFilters(Map < String, String > filters, String fields, Pageable requestedPage, Integer pageNumber, Integer pageSize) {
        log("findByFilters method started");
        MatchOperation matchStage = null;
        ProjectionOperation projectStage = null;
        Aggregation aggregation = null;
        if ( !filters.isEmpty() ) {
            filters.remove(Constants.OFFSET_KEY);
            filters.remove(Constants.LIMIT_KEY);
            if ( fields != null ) {
                filters.remove(Constants.FIELDS_KEY);
            }
            List < Criteria > criteriaList = new ArrayList <>();
            for ( Map.Entry < String, String > entry : filters.entrySet() ) {
                Criteria criteria = Criteria.where(entry.getKey()).in(entry.getValue());
                criteriaList.add(criteria);
            }
            matchStage = new MatchOperation(!criteriaList.isEmpty() ? new Criteria().andOperator(criteriaList.toArray(new Criteria[ criteriaList.size() ])) : new Criteria());
        }
        if ( fields != null ) {
            List < String > requiredFieldList = Stream.of(fields.split(",", -1)).collect(Collectors.toList());
            projectStage = Aggregation.project(requiredFieldList.toArray(new String[ 0 ]));//projectStage = Aggregation.project("href", "status");//at lease 1 param should be there
        }

        if ( !filters.isEmpty() ) {
            if ( pageNumber.equals(1) ) {
                aggregation = Aggregation.newAggregation(matchStage, limit(pageSize), sort(Sort.Direction.DESC, Constants.CUSTOMER_SORT_FIELD));//no need to pass skip param if you need the first page
            } else {
                aggregation = Aggregation.newAggregation(matchStage, skip((pageNumber - 1) * pageSize), limit(pageSize), sort(Sort.Direction.DESC, Constants.CUSTOMER_SORT_FIELD));
            }
        }

        if ( fields != null ) {
            if ( pageNumber.equals(1) ) {
                aggregation = Aggregation.newAggregation(projectStage, limit(pageSize), sort(Sort.Direction.DESC, Constants.CUSTOMER_SORT_FIELD));
            } else {
                aggregation = Aggregation.newAggregation(projectStage, skip((pageNumber - 1) * pageSize), limit(pageSize), sort(Sort.Direction.DESC, Constants.CUSTOMER_SORT_FIELD));
            }
        }

        if ( !filters.isEmpty() && fields != null ) {
            if ( pageNumber.equals(1) ) {
                aggregation = Aggregation.newAggregation(matchStage, projectStage, limit(pageSize), sort(Sort.Direction.DESC, Constants.CUSTOMER_SORT_FIELD));
            } else {
                aggregation = Aggregation.newAggregation(matchStage, projectStage, skip((pageNumber - 1) * pageSize), limit(pageSize), sort(Sort.Direction.DESC, Constants.CUSTOMER_SORT_FIELD));
            }
        }

        if ( filters.isEmpty() && fields == null ) {
            log("findByFilters method ended");
            return customerRepository.findAll(requestedPage).getContent();
        }

        AggregationResults < Customer > result = mongoTemplate.aggregate(aggregation, "customer", Customer.class);
        log("findByFilters method ended");
        return result.getMappedResults();
    }

    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
