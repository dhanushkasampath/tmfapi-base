package com.iit.msc.ase.tmf.datamodel.domain.dto;

import java.util.List;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iit.msc.ase.tmf.datamodel.domain.enums.OrderItemActionType;
import com.iit.msc.ase.tmf.datamodel.domain.enums.ProductOrderItemStateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY)
public class ProductOrderItem {
	public static final String PRODUCT_TABLE = "ProductRefOrValue";
	public static final String PRODUCTOFFERING_TABLE = "ProductOfferingRef";
	public static final String ITEMTOTALPRICE_TABLE = "OrderPrice";
	public static final String APPOINTMENT_TABLE = "AppointmentRef";
	public static final String BILLINGACCOUNT_TABLE = "BillingAccountRef";
	public static final String PRODUCTORDERITEM_TABLE = "ProductOrderItemItem";
	public static final String PRODUCTORDERITEMRELATIONSHIP_TABLE = "OrderItemRelationship";
	public static final String ITEMTERM_TABLE = "OrderTerm";
	public static final String QUALIFICATION_TABLE = "ProductOfferingQualificationRef";
	public static final String PRODUCTOFFERINGQUALIFICATIONITEM_TABLE = "ProductOfferingQualificationItemRef";
	public static final String QUOTEITEM_TABLE = "QuoteItemRef";
	public static final String ITEMPRICE_TABLE = "OrderPrice";
	public static final String PAYMENT_TABLE = "PaymentRef";

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

	private ProductRefOrValue product;
	private int quantity;
	private ProductOfferingRef productOffering;
	@JsonProperty("@type")
	private String type;
	private List<OrderPrice> itemTotalPrice;
	private AppointmentRef appointment;
	private BillingAccountRef billingAccount;
	private List<ProductOrderItemItem> productOrderItem;
	private List<OrderItemRelationship> productOrderItemRelationship;
	private List<OrderTerm> itemTerm;
	private List<ProductOfferingQualificationRef> qualification;
	private ProductOfferingQualificationItemRef productOfferingQualificationItem;
	@JsonProperty("@baseType")
	private String baseType;
	private OrderItemActionType action;
	private QuoteItemRef quoteItem;
	private List<OrderPrice> itemPrice;
	private List<PaymentRef> payment;
	@NotNull
	private String id;
	private ProductOrderItemStateType state;
	@JsonProperty("@schemaLocation")
	private String schemaLocation;
	@JsonProperty("@referredType")
	private String referredType;
	private String role;
	private String productOrderHref;
	private String orderItemId;
	private String productOrderId;
	private String orderItemAction;

	@Override
	public String toString(){
		return
				"ProductOrderItemItem{" +
						"product = '" + product + '\'' +
						",quantity = '" + quantity + '\'' +
						",productOffering = '" + productOffering + '\'' +
						",@type = '" + type + '\'' +
						",itemTotalPrice = '" + itemTotalPrice + '\'' +
						",appointment = '" + appointment + '\'' +
						",billingAccount = '" + billingAccount + '\'' +
			            ",productOrderItem = '" + productOrderItem + '\'' +
						",productOrderItemRelationship = '" + productOrderItemRelationship + '\'' +
						",itemTerm = '" + itemTerm + '\'' +
						",qualification = '" + qualification + '\'' +
						",productOfferingQualificationItem = '" + productOfferingQualificationItem + '\'' +
						",@baseType = '" + baseType + '\'' +
						",action = '" + action + '\'' +
						",quoteItem = '" + quoteItem + '\'' +
						",itemPrice = '" + itemPrice + '\'' +
						",payment = '" + payment + '\'' +
						",id = '" + id + '\'' +
						",state = '" + state + '\'' +
						",@schemaLocation = '" + schemaLocation + '\'' +
						",@referredType = '" + referredType + '\'' +
						",role = '" + role + '\'' +
						",productOrderHref = '" + productOrderHref + '\'' +
						",orderItemId = '" + orderItemId + '\'' +
						",productOrderId = '" + productOrderId + '\'' +
						",orderItemAction = '" + orderItemAction + '\'' +
						"}";
	}
}