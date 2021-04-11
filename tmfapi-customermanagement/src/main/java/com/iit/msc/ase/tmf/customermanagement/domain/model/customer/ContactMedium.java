package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMedium {

    private String mediumType;
    private boolean preferred;
    private TimePeriod validFor;
    private MediumCharacteristic characteristic;
    private String baseType;
    private String schemaLocation;
}
