package com.iit.msc.ase.tmf.datamodel.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class RelatedProductOrderItem {
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

    @JsonProperty("@referredType")
    private String referredType;
    private String role;
    private String productOrderHref;
    @JsonProperty("@baseType")
    private String baseType;
    private String orderItemId;
    @JsonProperty("@type")
    private String type;
    private String productOrderId;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String orderItemAction;

    @Override
    public String toString(){
        return
                "Response{" +
                        "@referredType = '" + referredType + '\'' +
                        ",role = '" + role + '\'' +
                        ",productOrderHref = '" + productOrderHref + '\'' +
                        ",@baseType = '" + baseType + '\'' +
                        ",orderItemId = '" + orderItemId + '\'' +
                        ",@type = '" + type + '\'' +
                        ",productOrderId = '" + productOrderId + '\'' +
                        ",@schemaLocation = '" + schemaLocation + '\'' +
                        ",orderItemAction = '" + orderItemAction + '\'' +
                        "}";
    }
}

