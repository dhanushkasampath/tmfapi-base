package com.iit.msc.ase.tmf.datamodel.domain.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
public class CustomerDto {

    private String id;

    @NotNull
    private String href;

    @JsonProperty( "@type" )
    private String type;

    private String status;

    private String statusReason;

    @JsonProperty( "@baseType" )
    private String baseType;

    @NotNull
    private String name;

    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    private TimePeriodDto validFor;

    @Valid
    private List < ContactMediumDto > contactMedium;

    @Valid
    private List < CreditProfileDto > creditProfile;

    private List < AgreementRefDto > agreement;

    private List < RelatedPartyDto > relatedParty;

    @Valid
    private List < CharacteristicDto > characteristic;

    private List < PaymentRefDto > paymentMethod;

    @Valid
    private List < AccountRefDto > account;

    @NotNull
    private List < EngagedPartyDto > engagedParty;

}