package com.iit.msc.ase.tmf.datamodel.domain.dto;

import java.util.List;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class ProductPrice {
	public static final String PRICE_TABLE = "Price";
	public static final String PRODUCTOFFERINGPRICE_TABLE = "ProductOfferingPriceRef";
	public static final String BILLINGACCOUNT_TABLE = "BillingAccountRef";
	public static final String PRODUCTPRICEALTERATION_TABLE = "PriceAlteration";

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

	private String unitOfMeasure;
	@JsonProperty("@baseType")
	private String baseType;
	@Valid
	private Price price;
	@JsonProperty("@type")
	private String type;
	private String name;
	private String priceType;
	private String description;
	@Valid
	private ProductOfferingPriceRef productOfferingPrice;
	private String recurringChargePeriod;
	@Valid
	private BillingAccountRef billingAccount;
	private String schemaLocation;
	@Valid
	private List<PriceAlteration> productPriceAlteration;

	@Override
 	public String toString(){
		return 
			"ProductPriceItem{" + 
			"unitOfMeasure = '" + unitOfMeasure + '\'' + 
			",@baseType = '" + baseType + '\'' + 
			",price = '" + price + '\'' + 
			",@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			",priceType = '" + priceType + '\'' + 
			",description = '" + description + '\'' + 
			",productOfferingPrice = '" + productOfferingPrice + '\'' + 
			",recurringChargePeriod = '" + recurringChargePeriod + '\'' + 
			",billingAccount = '" + billingAccount + '\'' + 
			",@schemaLocation = '" + schemaLocation + '\'' + 
			",productPriceAlteration = '" + productPriceAlteration + '\'' + 
			"}";
		}
}