package com.iit.msc.ase.tmf.datamodel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class OrderItemRelationship {
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

	private String relationshipType;
	private String baseType;
	private String type;
	private String id;
	private String schemaLocation;

	@Override
 	public String toString(){
		return 
			"ProductOrderItemRelationshipItem{" + 
			"relationshipType = '" + relationshipType + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",@type = '" + type + '\'' + 
			",id = '" + id + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			"}";
		}
}
