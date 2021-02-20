package com.iit.msc.ase.tmf.customermanagement.domain.model;

import java.util.List;

import com.iit.msc.ase.tmf.datamodel.domain.dto.EngagedPartyDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.TimePeriodDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@Document( collection = "customer" )
public class Customer {

    private String id;
    private String href;
    private EngagedPartyDto engagedParty;
    private String status;
    private TimePeriodDto validFor;
    private String type;
    private String statusReason;
    private String baseType;
    private String name;
    private String schemaLocation;

    @DBRef
    private List < ContactMedium > contactMediumIdList;

    @DBRef
    private List < CreditProfile > creditProfileIdList;

    @DBRef
    private List < AgreementRef > agreementIdList;

    @DBRef
    private List < RelatedParty > relatedPartyIdList;

    @DBRef
    private List < Characteristic > characteristicIdList;

    @DBRef
    private List < PaymentRef > paymentMethodIdList;

    @DBRef
    private List < AccountRef > accountIdList;


}
