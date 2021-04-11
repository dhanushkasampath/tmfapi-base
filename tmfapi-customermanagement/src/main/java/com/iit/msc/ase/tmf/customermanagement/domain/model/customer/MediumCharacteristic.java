package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediumCharacteristic {

    private String href;
    private String country;
    private String city;
    private String contactType;
    private String socialNetworkId;
    private String emailAddress;
    private String phoneNumber;
    private String stateOrProvince;
    private String faxNumber;
    private String postCode;
    private String street1;
    private String street2;
    private String schemaLocation;
    private String type;
    private String baseType;
}
