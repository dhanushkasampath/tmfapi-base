package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CreditProfileDto {

    @NotNull
    private String creditProfileDate;

    private int creditScore;

    @JsonProperty( "@baseType" )
    private String baseType;

    @NotNull
    private TimePeriodDto validFor;

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
