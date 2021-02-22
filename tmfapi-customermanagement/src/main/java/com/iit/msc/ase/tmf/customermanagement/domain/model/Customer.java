package com.iit.msc.ase.tmf.customermanagement.domain.model;

import java.util.List;

import com.iit.msc.ase.tmf.datamodel.domain.dto.EngagedPartyDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.TimePeriodDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document( collection = "customer" )
public class Customer {

    @Id
    private String id;
    private String href;
    private String status;
    private String type;
    private String statusReason;
    private String baseType;
    private String name;
    private String schemaLocation;

    @DBRef
    private List < EngagedParty > engagedParty;

    @DBRef
    private TimePeriod validFor;

    @DBRef
    private List < ContactMedium > contactMedium;

    @DBRef
    private List < CreditProfile > creditProfile;

    @DBRef
    private List < AgreementRef > agreement;

    @DBRef
    private List < RelatedParty > relatedParty;

    @DBRef
    private List < Characteristic > characteristic;

    @DBRef
    private List < PaymentRef > paymentMethod;

    @DBRef
    private List < AccountRef > account;


}
