package com.iit.msc.ase.tmf.customermanagement.domain.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatedParty {

    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String href;

    @Indexed
    private String role;

    @Indexed
    private String referredType;

    private String baseType;

    @Indexed
    private String type;

    @Indexed
    private String schemaLocation;
}
