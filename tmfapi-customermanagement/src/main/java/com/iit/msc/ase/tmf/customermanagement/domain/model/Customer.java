package com.iit.msc.ase.tmf.customermanagement.domain.model;

import java.util.List;

import com.iit.msc.ase.tmf.datamodel.domain.dto.EngagedPartyDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.TimePeriodDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {

    private String id;
    private String href;
    private List < String > contactMediumIdList;
    private List < String > creditProfileIdList;
    private List < String > agreementIdList;
    private TimePeriodDto validFor;
    private String type;
    private List < String > relatedPartyIdList;
    private List < String > characteristicIdList;
    private String statusReason;
    private String baseType;
    private String name;
    private List < String > paymentMethodIdList;
    private String schemaLocation;
    private List < String > accountIdList;
    private EngagedPartyDto engagedParty;
    private String status;
}
