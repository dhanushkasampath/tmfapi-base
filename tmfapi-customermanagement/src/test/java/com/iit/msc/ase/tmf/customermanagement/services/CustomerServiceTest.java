package com.iit.msc.ase.tmf.customermanagement.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iit.msc.ase.tmf.commonconfig.application.exception.type.CustomerMgtException;
import com.iit.msc.ase.tmf.customermanagement.domain.boundary.repository.CustomerRepository;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.CreateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.QueryCustomerByIdRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerReqDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.feature.UpdateCustomerRespDto;
import com.iit.msc.ase.tmf.customermanagement.domain.dto.headers.RequestHeaderDto;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.AccountRef;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.Customer;
import com.iit.msc.ase.tmf.customermanagement.domain.model.customer.TimePeriod;
import com.iit.msc.ase.tmf.customermanagement.external.serviceimpl.CustomerServiceImpl;
import com.iit.msc.ase.tmf.datamodel.domain.dto.AccountRefDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.TimePeriodDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2020.09.30
 */
@RunWith( MockitoJUnitRunner.class )
public class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl mockCustomerService;

    @Mock
    private CustomerRepository mockCustomerRepository;

    private CreateCustomerReqDto createCustomerReqDto;

    private UpdateCustomerReqDto updateCustomerReqDto;

    private Customer customer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        createCustomerReqDto = getCreateCustomerReqDto();
        updateCustomerReqDto = getUpdateCustomerReqDto();
        customer = getCustomer();
        ReflectionTestUtils.setField(mockCustomerService, "customerHref", "http://host:port/tmf-api/customerManagement/v4/customer/<id>");
    }

    @Test
    public void testCreate()  {
        when(mockCustomerRepository.save(any(Customer.class))).thenReturn(customer);
        CreateCustomerRespDto createCustomerRespDto = mockCustomerService.create(createCustomerReqDto);
        assertEquals(String.valueOf(HttpStatus.OK.value()), createCustomerRespDto.getResponseHeader().getResponseCode());
    }

    @Test
    public void testQueryById()  {
        when(mockCustomerRepository.findById(any(String.class))).thenReturn(Optional.of(customer));
        QueryCustomerByIdRespDto queryCustomerByIdRespDto = mockCustomerService.queryById("6071da0b46e0fb0007f09f88");
        assertEquals(String.valueOf(HttpStatus.OK.value()), queryCustomerByIdRespDto.getResponseHeader().getResponseCode());
    }

    @Test
    public void testUpdate() throws CustomerMgtException {
        when(mockCustomerRepository.findById(any(String.class))).thenReturn(Optional.of(customer));
        when(mockCustomerRepository.save(any(Customer.class))).thenReturn(customer);
        UpdateCustomerRespDto updateCustomerRespDto = mockCustomerService.update("6071da0b46e0fb0007f09f88", updateCustomerReqDto);
        assertEquals(String.valueOf(HttpStatus.OK.value()), updateCustomerRespDto.getResponseHeader().getResponseCode());
    }

    @Test
    public void testQueryAll() throws CustomerMgtException {
        when(mockCustomerRepository.save(any(Customer.class))).thenReturn(customer);
        UpdateCustomerRespDto updateCustomerRespDto = mockCustomerService.update("6071da0b46e0fb0007f09f88", updateCustomerReqDto);
        assertEquals(String.valueOf(HttpStatus.OK.value()), updateCustomerRespDto.getResponseHeader().getResponseCode());
    }

    /**
     * @return
     */
    private RequestHeaderDto getRequestHeaderDto(){
        RequestHeaderDto adminRequestHeader = new RequestHeaderDto();
        adminRequestHeader.setRequestId("qwer-123-455fdv-56gfdf-65jd");
        adminRequestHeader.setChannel("web");
        adminRequestHeader.setTimestamp(LocalDateTime.now().toString());
        return adminRequestHeader;
    }

    private UpdateCustomerReqDto getUpdateCustomerReqDto() {
        UpdateCustomerReqDto updateCustomerReqDto = new UpdateCustomerReqDto();
        updateCustomerReqDto.setRequestHeader(getRequestHeaderDto());
        CustomerDto customerDto = new CustomerDto();
        customerDto.setType("Customer");
        customerDto.setHref("https://host:port/tmf-api/customerManagement/v4/customer/<id>");
        customerDto.setName("Dhanushka Sampath Updated");
        customerDto.setStatus("Approved");
        customerDto.setStatusReason("Account details checked");
        TimePeriodDto timePeriodDto = new TimePeriodDto();
        timePeriodDto.setStartDateTime("2021-06-12T00:00Z");
        timePeriodDto.setEndDateTime("2022-06-12T00:00Z");
        customerDto.setValidFor(timePeriodDto);
        List <AccountRefDto> accountRefDtoList = new ArrayList<>();
        AccountRefDto accountRefDto = new AccountRefDto();
        accountRefDto.setReferredType("BillingAccount");
        accountRefDto.setDescription("This is the billing account of customer");
        accountRefDto.setHref("https://host:port/tmf-api/accountManagement/v4/account/8251");
        accountRefDto.setName("Billing");
        accountRefDtoList.add(accountRefDto);
        customerDto.setAccount(accountRefDtoList);
        updateCustomerReqDto.setCustomer(customerDto);
        return updateCustomerReqDto;
    }

    /**
     * @return
     */
    private CreateCustomerReqDto getCreateCustomerReqDto() {
        CreateCustomerReqDto createCustomerReqDto = new CreateCustomerReqDto();
        createCustomerReqDto.setRequestHeader(getRequestHeaderDto());
        CustomerDto customerDto = new CustomerDto();
        customerDto.setType("Customer");
        customerDto.setHref("https://host:port/tmf-api/customerManagement/v4/customer/<id>");
        customerDto.setName("Dhanushka Sampath");
        customerDto.setStatus("Approved");
        customerDto.setStatusReason("Account details checked");
        TimePeriodDto timePeriodDto = new TimePeriodDto();
        timePeriodDto.setStartDateTime("2021-06-12T00:00Z");
        timePeriodDto.setEndDateTime("2022-06-12T00:00Z");
        customerDto.setValidFor(timePeriodDto);
        List <AccountRefDto> accountRefDtoList = new ArrayList<>();
        AccountRefDto accountRefDto = new AccountRefDto();
        accountRefDto.setReferredType("BillingAccount");
        accountRefDto.setDescription("This is the billing account of customer");
        accountRefDto.setHref("https://host:port/tmf-api/accountManagement/v4/account/8251");
        accountRefDto.setName("Billing");
        accountRefDtoList.add(accountRefDto);
        customerDto.setAccount(accountRefDtoList);
        createCustomerReqDto.setCustomer(customerDto);
        return createCustomerReqDto;
    }

    private Customer getCustomer() {
        Customer createdCustomer = new Customer();
        createdCustomer.setId("6071da0b46e0fb0007f09f88");
        createdCustomer.setType("Customer");
        createdCustomer.setHref("https://host:port/tmf-api/customerManagement/v4/customer/<id>");
        createdCustomer.setName("Dhanushka Sampath");
        createdCustomer.setStatus("Approved");
        createdCustomer.setStatusReason("Account details checked");
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setStartDateTime("2021-06-12T00:00Z");
        timePeriod.setEndDateTime("2022-06-12T00:00Z");
        createdCustomer.setValidFor(timePeriod);
        List < AccountRef > accountRefList = new ArrayList<>();
        AccountRef accountRef = new AccountRef();
        accountRef.setReferredType("BillingAccount");
        accountRef.setDescription("This is the billing account of customer");
        accountRef.setHref("https://host:port/tmf-api/accountManagement/v4/account/8251");
        accountRef.setName("Billing");
        accountRefList.add(accountRef);
        createdCustomer.setAccount(accountRefList);
        return createdCustomer;
    }
}
