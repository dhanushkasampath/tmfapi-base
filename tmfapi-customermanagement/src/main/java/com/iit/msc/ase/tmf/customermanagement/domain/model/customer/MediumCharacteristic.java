package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediumCharacteristic {

    @Indexed
    private String href;

    @Indexed
    private String country;

    @Indexed
    private String city;

    @Indexed
    private String contactType;

    private String socialNetworkId;

    @Indexed
    private String emailAddress;

    @Indexed
    private String phoneNumber;

    @Indexed
    private String stateOrProvince;

    @Indexed
    private String faxNumber;

    @Indexed
    private String postCode;

    @Indexed
    private String street1;

    private String street2;

    @Indexed
    private String schemaLocation;

    @Indexed
    private String type;

    @Indexed
    private String baseType;
}
