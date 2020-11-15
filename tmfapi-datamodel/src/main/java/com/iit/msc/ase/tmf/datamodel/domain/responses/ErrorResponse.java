package com.iit.msc.ase.tmf.datamodel.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	private String reason;
	private String code;
	@JsonProperty("@baseType")
	private String baseType;
	@JsonProperty("@type")
	private String type;
	private String message;
	private String referenceError;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;
	private String status;

	@Override
 	public String toString(){
		return 
			"ErrorResponse{" + 
			"reason = '" + reason + '\'' + 
			",code = '" + code + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",@type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",referenceError = '" + referenceError + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
