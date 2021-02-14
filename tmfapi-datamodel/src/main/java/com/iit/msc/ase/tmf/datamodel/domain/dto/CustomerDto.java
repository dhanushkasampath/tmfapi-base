package com.iit.msc.ase.tmf.datamodel.domain.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class CustomerDto {

    public static final String CONTACTMEDIUM_TABLE = "ContactMedium";
    public static final String CREDITPROFILE_TABLE = "CreditProfile";
    public static final String AGREEMENT_TABLE = "AgreementRef";
    public static final String RELATEDPARTY_TABLE = "RelatedParty";
    public static final String CHARACTERISTIC_TABLE = "Characteristic";
    public static final String PAYMENTMETHOD_TABLE = "PaymentRef";
    public static final String ACCOUNT_TABLE = "AccountRef";
    public static final String ENGAGEDPARTY_TABLE = "EngagedParty";
    public static final String VALIDFOR_TABLE = "TimePeriod";
    @NotNull
    private String id;
    @NotNull
    private String href;
    @Valid
    private List < ContactMediumDto > contactMedium;
    @Valid
    private List < CreditProfileDto > creditProfile;
    private List < AgreementRefDto > agreement;
    private TimePeriodDto validFor;
    @JsonProperty( "@type" )
    private String type;
    private List < RelatedPartyDto > relatedParty;
    @Valid
    private List < CharacteristicDto > characteristic;
    private String statusReason;
    @JsonProperty( "@baseType" )
    private String baseType;
    @NotNull
    private String name;
    private List < PaymentRefDto > paymentMethod;
    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;
    @Valid
    private List < AccountRefDto > account;
    @NotNull
    private EngagedPartyDto engagedParty;
    private String status;
}