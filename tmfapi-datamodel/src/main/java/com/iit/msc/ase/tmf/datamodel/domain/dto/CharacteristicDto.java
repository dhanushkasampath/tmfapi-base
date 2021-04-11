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
public class CharacteristicDto {

    @JsonProperty( "@baseType" )
    private String baseType;

    @JsonProperty( "@type" )
    private String type;

    private String valueType;

    private String value;

    private String name;

    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    @Override
    public String toString() {
        return
                "CharacteristicItem{" +
                        "@baseType = '" + baseType + '\'' +
                        ",@type = '" + type + '\'' +
                        ",valueType = '" + valueType + '\'' +
                        ",name = '" + name + '\'' +
                        ",@schemaLocation = '" + schemaLocation + '\'' +
                        "}";
    }

}
