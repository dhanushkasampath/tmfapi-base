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
public class PaymentRefDto {

    @JsonProperty( "@referredType" )
    private String referredType;

    @JsonProperty( "@baseType" )
    private String baseType;

    @JsonProperty( "@type" )
    private String type;

    private String name;

    private String id;

    private String href;

    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    @Override
    public String toString() {
        return
                "PaymentMethodItem{" +
                        "@referredType = '" + referredType + '\'' +
                        ",@baseType = '" + baseType + '\'' +
                        ",@type = '" + type + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",href = '" + href + '\'' +
                        ",@schemaLocation = '" + schemaLocation + '\'' +
                        "}";
    }

}
