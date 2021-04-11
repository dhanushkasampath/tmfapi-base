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
public class CreditProfile {

    private String creditProfileDate;
    private int creditScore;
    private String baseType;
    private TimePeriod validFor;
    private String type;
    private int creditRiskRating;
    private String schemaLocation;
}
