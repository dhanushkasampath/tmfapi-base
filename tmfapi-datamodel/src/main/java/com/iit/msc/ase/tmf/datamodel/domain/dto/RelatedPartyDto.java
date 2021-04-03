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
public class RelatedPartyDto {

    @NotNull
    private String name;

    @NotNull
    private String id;

    @NotNull
    private String href;

    @NotNull
    private String role;

    @JsonProperty( "@referredType" )
    private String referredType;

    @JsonProperty( "@baseType" )
    private String baseType;

    @JsonProperty( "@type" )
    private String type;

    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    @Override
    public String toString() {
        return "RelatedParty{" +
                ", referredType='" + referredType + '\'' +
                ", role='" + role + '\'' +
                ", baseType='" + baseType + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", href='" + href + '\'' +
                ", schemaLocation='" + schemaLocation + '\'' +
                '}';
    }

}
