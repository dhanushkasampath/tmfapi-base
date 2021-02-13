package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class CreditProfile {

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
    private String creditProfileDate;
    private int creditScore;
    @JsonProperty( "@baseType" )
    private String baseType;
    @NotNull
    private TimePeriod validFor;
    @JsonProperty( "@type" )
    private String type;
    private int creditRiskRating;
    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;


    @Override
    public String toString() {
        return
                "CreditProfileItem{" +
                        "creditProfileDate = '" + creditProfileDate + '\'' +
                        ",creditScore = '" + creditScore + '\'' +
                        ",@baseType = '" + baseType + '\'' +
                        ",validFor = '" + validFor + '\'' +
                        ",@type = '" + type + '\'' +
                        ",creditRiskRating = '" + creditRiskRating + '\'' +
                        ",@schemaLocation = '" + schemaLocation + '\'' +
                        "}";
    }

}
