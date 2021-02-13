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
public class Characteristic {

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

    @JsonProperty( "@baseType" )
    private String baseType;
    @JsonProperty( "@type" )
    private String type;
    @NotNull
    private String valueType;
    @NotNull
    private String value;
    @NotNull
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
