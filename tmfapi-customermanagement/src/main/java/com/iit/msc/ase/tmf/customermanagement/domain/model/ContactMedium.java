package com.iit.msc.ase.tmf.customermanagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contact_medium")
public class ContactMedium {

    private String id;
    private long primaryId;
    private String parentEntity;
    private String parentId;
    private String immediateParent;
    private String immediateParentId;
    private String mediumType;
    private boolean preferred;
    private TimePeriod validFor;
    private MediumCharacteristic characteristic;
    private String baseType;
    private String referredType;
    private String schemaLocation;
}
