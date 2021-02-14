package com.iit.msc.ase.tmf.customermanagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@Document(collection = "medium_characteristic")
public class MediumCharacteristic {

    private long primaryId;
    private String parentEntity;
    private String parentId;
    private String immediateParent;
    private String immediateParentId;
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
