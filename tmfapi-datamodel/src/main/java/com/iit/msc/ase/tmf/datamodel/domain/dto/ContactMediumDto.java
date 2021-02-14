package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class ContactMediumDto {

    public static final String CHARACTERISTIC_TABLE = "MediumCharacteristic";
    public static final String VALIDFOR_TABLE = "TimePeriod";

    @JsonIgnore
    private long primaryId;
    @JsonIgnore
    private String parentEntity;
    @JsonIgnore
    private String parentId;
    @JsonIgnore
    private String immediateParent;
    @JsonIgnore
    private String immediateParentId;
    @NotNull
    private String mediumType;
    private boolean preferred;


    private TimePeriodDto validFor;
    @Valid
    @NotNull
    private MediumCharacteristicDto characteristic;

    @JsonProperty( "@baseType" )
    private String baseType;
    @JsonProperty( "@type" )
    private String type;
    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    @Override
    public String toString() {
        return "ContactMedium{" +
                "primaryId=" + primaryId +
                ", mediumType='" + mediumType + '\'' +
                ", preferred=" + preferred +
                ", validFor=" + validFor +
                ", characteristic=" + characteristic +
                ", baseType='" + baseType + '\'' +
                ", type='" + type + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                '}';
    }

}
