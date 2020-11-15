package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class Price {
	public static final String TAXINCLUDEDAMOUNT_TABLE = "Money";
	public static final String DUTYFREEAMOUNT_TABLE = "Money";

	@JsonIgnore
	private long primaryId;
	@JsonIgnore
	private String parentEntity;
	@JsonIgnore
	private String parentId;
	@JsonIgnore
	private String immediateParent;
	@JsonIgnore
	private String immediateParentId;

	private int taxRate;
	@JsonProperty("@baseType")
	private String baseType;
	@JsonProperty("@type")
	private String type;
	private int percentage;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;
	@Valid
	private Money taxIncludedAmount;
	@Valid
	private Money dutyFreeAmount;

	@Override
 	public String toString(){
		return 
			"Price{" + 
			"taxRate = '" + taxRate + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",@type = '" + type + '\'' + 
			",percentage = '" + percentage + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			",taxIncludedAmount = '" + taxIncludedAmount + '\'' + 
			",dutyFreeAmount = '" + dutyFreeAmount + '\'' + 
			"}";
		}
}
