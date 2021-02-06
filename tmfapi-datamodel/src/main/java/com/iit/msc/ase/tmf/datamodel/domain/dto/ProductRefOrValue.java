package com.iit.msc.ase.tmf.datamodel.domain.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iit.msc.ase.tmf.datamodel.domain.enums.ProductStatusType;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class ProductRefOrValue {
	public static final String PRODUCTSPECIFICATION_TABLE = "ProductSpecificationRef";
	public static final String PRODUCTCHARACTERISTIC_TABLE = "Characteristic";
	public static final String BILLINGACCOUNT_TABLE = "BillingAccountRef";
	public static final String PRODUCTORDERITEMS_TABLE = "RelatedProductOrderItem";
	public static final String REALIZINGSERVICE_TABLE = "ServiceRef";
	public static final String REALIZINGRESOURCE_TABLE = "ResourceRef";
	public static final String PLACE_TABLE = "RelatedPlaceRefOrValue";
	public static final String PRODUCTLIST_TABLE = "ProductRefOrValueItem";
	public static final String AGREEMENT_TABLE = "AgreementItemRef";
	public static final String PRODUCTOFFERING_TABLE = "ProductOfferingRef";
	public static final String PRODUCTTERM_TABLE = "ProductTerm";
	public static final String RELATEDPARTY_TABLE = "RelatedParty";
	public static final String PRODUCTRELATIONSHIP_TABLE = "ProductRelationship";
	public static final String PRODUCTPRICE_TABLE = "ProductPrice";

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

	private boolean isBundle;
	@Valid
	private ProductSpecificationRef productSpecification;
	@JsonProperty("@referredType")
	private String referredType;
	@JsonProperty("@type")
	private String type;
	@Valid
	private List<Characteristic> productCharacteristic;
	private String description;
	@Valid
	private BillingAccountRef billingAccount;
	@Valid
	private List<RelatedProductOrderItem> productOrderItems;
	@Valid
	private List<ServiceRef> realizingService;
	private String terminationDate;
	@JsonProperty("@baseType")
	private String baseType;
	@Valid
	private List<ResourceRef> realizingResource;
	@NotNull
	private String id;
	private String href;
	@Valid
	private List<RelatedPlaceRefOrValue> place;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;
	@Valid
	private List<ProductRefOrValueItem> productList;
	@Valid
	private List<AgreementItemRef> agreement;
	@Valid
	private ProductOfferingRef productOffering;
	@Valid
	private List<ProductTerm> productTerm;
	@Valid
	private List<RelatedParty> relatedParty;
	private String productSerialNumber;
	private String name;
	@Valid
	private List<ProductRelationship> productRelationship;
	private boolean isCustomerVisible;
	private String orderDate;
	private String startDate;
	@Valid
	private List<ProductPrice> productPrice;
	private ProductStatusType status;

	@Override
	public String toString(){
		return
				"Product{" +
						"isBundle = '" + isBundle + '\'' +
						",productSpecification = '" + productSpecification + '\'' +
						",@referredType = '" + referredType + '\'' +
						",@type = '" + type + '\'' +
						",productCharacteristic = '" + productCharacteristic + '\'' +
						",description = '" + description + '\'' +
						",billingAccount = '" + billingAccount + '\'' +
						",productOrderItem = '" + productOrderItems + '\'' +
						",realizingService = '" + realizingService + '\'' +
						",terminationDate = '" + terminationDate + '\'' +
						",@baseType = '" + baseType + '\'' +
						",realizingResource = '" + realizingResource + '\'' +
						",id = '" + id + '\'' +
						",href = '" + href + '\'' +
						",place = '" + place + '\'' +
						",@schemaLocation = '" + schemaLocation + '\'' +
						",product = '" + productList + '\'' +
						",agreement = '" + agreement + '\'' +
						",productOffering = '" + productOffering + '\'' +
						",productTerm = '" + productTerm + '\'' +
						",relatedParty = '" + relatedParty + '\'' +
						",productSerialNumber = '" + productSerialNumber + '\'' +
						",name = '" + name + '\'' +
						",productRelationship = '" + productRelationship + '\'' +
						",isCustomerVisible = '" + isCustomerVisible + '\'' +
						",orderDate = '" + orderDate + '\'' +
						",startDate = '" + startDate + '\'' +
						",productPrice = '" + productPrice + '\'' +
						",status = '" + status + '\'' +
						"}";
	}
}

