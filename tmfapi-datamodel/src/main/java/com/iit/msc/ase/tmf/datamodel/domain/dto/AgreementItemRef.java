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
public class AgreementItemRef {

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
  private String id;
  private String href;
  private String agreementItemId;
  private String name;
  @JsonProperty("@baseType")
  private String baseType;
  @JsonProperty("@schemaLocation")
  private String schemaLocation;
  @JsonProperty("@type")
  private String type;
  @JsonProperty("@referredType")
  private String referredType;

  @Override
  public String toString() {
    return "AgreementItemRef{" +
            "id='" + id + '\'' +
            ", href='" + href + '\'' +
            ", agreementItemId='" + agreementItemId + '\'' +
            ", name='" + name + '\'' +
            ", baseType='" + baseType + '\'' +
            ", schemaLocation='" + schemaLocation + '\'' +
            ", type='" + type + '\'' +
            ", referredType='" + referredType + '\'' +
            '}';
  }
}

