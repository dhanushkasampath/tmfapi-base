package com.iit.msc.ase.tmf.datamodel.domain.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iit.msc.ase.tmf.datamodel.domain.enums.ProductOrderStateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude( JsonInclude.Include.NON_EMPTY )
public class ProductOrder {

    public static final String NOTE_TABLE = "Note";
    public static final String CHANNEL_TABLE = "RelatedChannel";
    public static final String BILLINGACCOUNT_TABLE = "BillingAccountRef";
    public static final String PRODUCTORDERITEM_TABLE = "ProductOrderItem";
    public static final String QUOTE_TABLE = "QuoteRef";
    public static final String PAYMENT_TABLE = "PaymentRef";
    public static final String AGREEMENT_TABLE = "AgreementRef";
    public static final String ORDERTOTALPRICE_TABLE = "OrderPrice";
    public static final String PRODUCTOFFERINGQUALIFICATION_TABLE = "ProductOfferingQualificationRef";
    public static final String RELATEDPARTY_TABLE = "RelatedParty";

    @Valid
    private List < Note > note;
    @JsonProperty( "@type" )
    private String type;
    @Valid
    private List < RelatedChannel > channel;
    private String description;
    @Valid
    private BillingAccountRef billingAccount;
    @Valid
    private List < ProductOrderItem > productOrderItem;
    private String requestedStartDate;
    @Valid
    private List < QuoteRef > quote;
    @JsonProperty( "@baseType" )
    private String baseType;
    @Valid
    private List < PaymentRef > payment;
    @NotNull
    private String id;
    private String href;
    @NotNull
    private ProductOrderStateType state;

    @JsonProperty( "@schemaLocation" )
    private String schemaLocation;

    private String cancellationDate;

    private String requestedCompletionDate;

    @Valid
    private List < AgreementRef > agreement;

    private String cancellationReason;
    @Valid
    private List < OrderPrice > orderTotalPrice;

    @Valid
    private List < ProductOfferingQualificationRef > productOfferingQualification;

    private String externalId;

    private String priority;

    @Valid
    private List < RelatedParty > relatedParty;

    private String notificationContact;
    private String completionDate;
    private String expectedCompletionDate;
    private String category;
    private String orderDate;

    @Override
    public String toString() {
        return
                "ProductOrderCreateRequestBody{" +
                        "note = '" + note + '\'' +
                        ",@type = '" + type + '\'' +
                        ",channel = '" + channel + '\'' +
                        ",description = '" + description + '\'' +
                        ",billingAccount = '" + billingAccount + '\'' +
                        ",productOrderItem = '" + productOrderItem + '\'' +
                        ",requestedStartDate = '" + requestedStartDate + '\'' +
                        ",quote = '" + quote + '\'' +
                        ",@baseType = '" + baseType + '\'' +
                        ",payment = '" + payment + '\'' +
                        ",id = '" + id + '\'' +
                        ",href = '" + href + '\'' +
                        ",state = '" + state + '\'' +
                        ",@schemaLocation = '" + schemaLocation + '\'' +
                        ",cancellationDate = '" + cancellationDate + '\'' +
                        ",requestedCompletionDate = '" + requestedCompletionDate + '\'' +
                        ",agreement = '" + agreement + '\'' +
                        ",cancellationReason = '" + cancellationReason + '\'' +
                        ",orderTotalPrice = '" + orderTotalPrice + '\'' +
                        ",productOfferingQualification = '" + productOfferingQualification + '\'' +
                        ",externalId = '" + externalId + '\'' +
                        ",priority = '" + priority + '\'' +
                        ",relatedParty = '" + relatedParty + '\'' +
                        ",notificationContact = '" + notificationContact + '\'' +
                        ",completionDate = '" + completionDate + '\'' +
                        ",expectedCompletionDate = '" + expectedCompletionDate + '\'' +
                        ",category = '" + category + '\'' +
                        ",orderDate = '" + orderDate + '\'' +
                        "}";
    }

}