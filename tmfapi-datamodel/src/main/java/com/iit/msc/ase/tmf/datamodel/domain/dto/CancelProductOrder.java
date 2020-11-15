package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iit.msc.ase.tmf.datamodel.domain.enums.TaskStateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class CancelProductOrder {
	public static final String PRODUCTORDER_TABLE = "ProductOrderRef";

	private String requestedCancellationDate;
	@JsonProperty("@baseType")
	private String baseType;
	private String cancellationReason;
	@JsonProperty("@type")
	private String type;
	@Valid
	private ProductOrderRef productOrder;
	@NotNull
	private String id;
	private String href;
	@NotNull
	private TaskStateType state;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;
	private String effectiveCancellationDate;

	@Override
 	public String toString(){
		return 
			"CancelProductOrder{" + 
			"requestedCancellationDate = '" + requestedCancellationDate + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",cancellationReason = '" + cancellationReason + '\'' + 
			",@type = '" + type + '\'' + 
			",productOrder = '" + productOrder + '\'' + 
			",id = '" + id + '\'' + 
			",href = '" + href + '\'' + 
			",state = '" + state + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			",effectiveCancellationDate = '" + effectiveCancellationDate + '\'' + 
			"}";
		}
}
