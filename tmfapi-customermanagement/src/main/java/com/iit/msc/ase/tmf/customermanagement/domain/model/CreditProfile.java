package com.iit.msc.ase.tmf.customermanagement.domain.model;

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
@Document(collection = "credit_profile")
public class CreditProfile {

}
