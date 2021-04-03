package com.iit.msc.ase.tmf.datamodel.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class MediumCharacteristicDto {

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
    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;
    @JsonProperty( "@type" )
    private String type;
    @JsonProperty( "@baseType" )
    private String baseType;

    @Override
    public String toString() {
        return "MediumCharacteristic{" +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", contactType='" + contactType + '\'' +
                ", socialNetworkId='" + socialNetworkId + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", stateOrProvince='" + stateOrProvince + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                ", type='" + type + '\'' +
                ", baseType='" + baseType + '\'' +
                '}';
    }

}
