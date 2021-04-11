package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.Valid;
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
public class ContactMediumDto {

    private String mediumType;

    private boolean preferred;

    private TimePeriodDto validFor;

    @Valid
    private MediumCharacteristicDto characteristic;

    @JsonProperty( "@baseType" )
    private String baseType;

    @JsonProperty( "@referredType" )
    private String referredType;

    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    @Override
    public String toString() {
        return "ContactMedium{" +
                ", mediumType='" + mediumType + '\'' +
                ", preferred=" + preferred +
                ", validFor=" + validFor +
                ", characteristic=" + characteristic +
                ", baseType='" + baseType + '\'' +
                ", referredType='" + referredType + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                '}';
    }

}
