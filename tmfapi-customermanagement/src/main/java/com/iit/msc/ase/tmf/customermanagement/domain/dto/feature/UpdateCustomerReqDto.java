package com.iit.msc.ase.tmf.customermanagement.domain.dto.feature;

import javax.validation.Valid;

import com.iit.msc.ase.tmf.customermanagement.domain.dto.headers.RequestHeaderDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.03.07
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerReqDto {

    @Valid
    private RequestHeaderDto requestHeader;

    private CustomerDto customer;

}

