package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngagedParty {

    @Id
    private String id;
    private String referredType;
    private String role;
    private String baseType;
    private String type;
    private String name;
    private String href;
    private String schemaLocation;
}
