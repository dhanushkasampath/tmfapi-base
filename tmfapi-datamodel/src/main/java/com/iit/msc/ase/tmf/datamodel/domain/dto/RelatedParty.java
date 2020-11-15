package com.iit.msc.ase.tmf.datamodel.domain.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class RelatedParty {

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

	@NotNull
	private String name;
	@NotNull
	private String id;
	@NotNull
	private String href;
	@NotNull
	private String role;

	@JsonProperty("@referredType")
	private String referredType;
	@JsonProperty("@baseType")
	private String baseType;
	@JsonProperty("@type")
	private String type;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;

	@Override
	public String toString() {
		return "RelatedParty{" +
				"primaryId=" + primaryId +
				", parentEntity='" + parentEntity + '\'' +
				", parentId='" + parentId + '\'' +
				", immediateParent='" + immediateParent + '\'' +
				", immediateParentId='" + immediateParentId + '\'' +
				", referredType='" + referredType + '\'' +
				", role='" + role + '\'' +
				", baseType='" + baseType + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", id='" + id + '\'' +
				", href='" + href + '\'' +
				", schemaLocation='" + schemaLocation + '\'' +
				'}';
	}
}
