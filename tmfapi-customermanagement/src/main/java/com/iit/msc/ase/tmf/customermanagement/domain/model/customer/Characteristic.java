package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

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
@Document(collection = "characteristic")
public class Characteristic {

    private String id;//added by me
    private long primaryId;
    private String parentEntity;
    private String parentId;
    private String immediateParent;
    private String immediateParentId;
    private String baseType;
    private String type;
    private String valueType;
    private String value;
    private String name;
    private String schemaLocation;
}
