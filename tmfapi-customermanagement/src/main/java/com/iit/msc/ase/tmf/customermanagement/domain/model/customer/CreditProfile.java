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
public class CreditProfile {

    @Indexed
    private String creditProfileDate;

    private int creditScore;
    private String baseType;
    private TimePeriod validFor;

    @Indexed
    private String type;

    private int creditRiskRating;

    @Indexed
    private String schemaLocation;
}
