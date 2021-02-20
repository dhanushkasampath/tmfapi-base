package com.iit.msc.ase.tmf.customermanagement.domain.model;

import com.iit.msc.ase.tmf.datamodel.domain.dto.MediumCharacteristicDto;
import com.iit.msc.ase.tmf.datamodel.domain.dto.TimePeriodDto;
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
    private TimePeriodDto validFor;
    private MediumCharacteristicDto characteristic;
    private String baseType;
    private String type;
    private String schemaLocation;
}
