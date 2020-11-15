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
public class PriceAlteration {
	public static final String PRICE_TABLE = "Price";
	public static final String PRODUCTOFFERINGPRICE_TABLE = "ProductOfferingPriceRef";

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

	private int applicationDuration;
	private String unitOfMeasure;
	@JsonProperty("@baseType")
	private String baseType;
	private Price price;
	@JsonProperty("@type")
	private String type;
	private String name;
	private String priceType;
	private String description;
	@Valid
	private ProductOfferingPriceRef productOfferingPrice;
	private int priority;
	private String recurringChargePeriod;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;

	@Override
 	public String toString(){
		return 
			"PriceAlterationItem{" + 
			"applicationDuration = '" + applicationDuration + '\'' + 
			",unitOfMeasure = '" + unitOfMeasure + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",price = '" + price + '\'' + 
			",@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			",priceType = '" + priceType + '\'' + 
			",description = '" + description + '\'' + 
			",productOfferingPrice = '" + productOfferingPrice + '\'' + 
			",priority = '" + priority + '\'' + 
			",recurringChargePeriod = '" + recurringChargePeriod + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			"}";
		}
}
