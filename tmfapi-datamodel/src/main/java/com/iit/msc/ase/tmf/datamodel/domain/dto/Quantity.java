package com.iit.msc.ase.tmf.datamodel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class Quantity {
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

	private int amount;
	private String units;

	@Override
 	public String toString(){
		return 
			"Size{" + 
			"amount = '" + amount + '\'' + 
			",units = '" + units + '\'' + 
			"}";
		}
}
