package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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
    private TimePeriod validFor;

    private List < EngagedParty > engagedParty;

    private List < ContactMedium > contactMedium;

    private List < CreditProfile > creditProfile;

    private List < AgreementRef > agreement;

    private List < RelatedParty > relatedParty;

    private List < Characteristic > characteristic;

    private List < PaymentRef > paymentMethod;

    private List < AccountRef > account;

}
