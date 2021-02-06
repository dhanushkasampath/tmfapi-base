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
public class ProductTerm {
	public static final String DURATION_TABLE = "Quantity";
	public static final String VALIDFOR_TABLE = "TimePeriod";

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

	private Quantity duration;
	@JsonProperty("@baseType")
	private String baseType;
	@Valid
	private TimePeriod validFor;
	@JsonProperty("@type")
	private String type;
	private String name;
	private String description;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;

	@Override
 	public String toString(){
		return 
			"ProductTermItem{" + 
			"duration = '" + duration + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",validFor = '" + validFor + '\'' + 
			",@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			"}";
		}
}
