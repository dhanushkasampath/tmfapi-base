package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMedium {

    @Indexed
    private String mediumType;

    @Indexed
    private boolean preferred;
    private TimePeriod validFor;
    private MediumCharacteristic characteristic;

    private String baseType;

    @Indexed
    private String schemaLocation;
}
