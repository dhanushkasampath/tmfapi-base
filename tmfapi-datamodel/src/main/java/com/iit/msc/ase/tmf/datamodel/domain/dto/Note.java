package com.iit.msc.ase.tmf.datamodel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class Note {
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

	private String date;
	private String author;
	private String id;
	private String text;

	@JsonProperty("@baseType")
	private String baseType;
	@JsonProperty("@type")
	private String type;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;

	@Override
 	public String toString(){
		return 
			"NoteItem{" + 
			"date = '" + date + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",author = '" + author + '\'' + 
			",@type = '" + type + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			"}";
		}
}
