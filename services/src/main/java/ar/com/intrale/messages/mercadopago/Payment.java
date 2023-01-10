package ar.com.intrale.messages.mercadopago;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Payment {

    @JsonProperty("acquirer_reconciliation")
    private List<String> acquirerReconciliation;
    @JsonProperty("additional_info")
    private AdditionalInfo additionalInfo;
    @JsonProperty("authorization_code")
    private String authorizationCode;
    private Barcode barcode;
    @JsonProperty("binary_mode")
    private boolean binaryMode;
    @JsonProperty("brand_id")
    private String brandId;
    @JsonProperty("build_version")
    private String buildVersion;
    @JsonProperty("call_for_authorize_id")
    private String callForAuthorizeId;
    private boolean captured;
    private Card card;
    @JsonProperty("charges_details")
    private List<String> chargesDetails;
    @JsonProperty("collector_id")
    private int collectorId;
    @JsonProperty("corporation_id")
    private String corporationId;
    @JsonProperty("counter_currency")
    private String counterCurrency;
    @JsonProperty("coupon_amount")
    private int couponAmount;
    @JsonProperty("currency_id")
    private String currencyId;
    @JsonProperty("date_approved")
    private String dateApproved;
    @JsonProperty("date_created")
    private Date dateCreated;
    @JsonProperty("date_last_updated")
    private Date dateLastUpdated;
    @JsonProperty("date_of_expiration")
    private Date dateOfExpiration;
    @JsonProperty("deduction_schema")
    private String deductionSchema;
    private String description;
    @JsonProperty("differential_pricing_id")
    private String differentialPricingId;
    @JsonProperty("external_reference")
    private String externalReference;
    @JsonProperty("fee_details")
    private List<String> feeDetails;
    @JsonProperty("financing_group")
    private String financingGroup;
    private int id;
    private int installments;
    @JsonProperty("integrator_id")
    private String integratorId;
    @JsonProperty("issuer_id")
    private String issuerId;
    @JsonProperty("live_mode")
    private boolean liveMode;
    @JsonProperty("marketplace_owner")
    private String marketplaceOwner;
    @JsonProperty("merchant_account_id")
    private String merchantAccountId;
    @JsonProperty("merchant_number")
    private String merchantNumber;
    private Metadata metadata;
    @JsonProperty("money_release_date")
    private String moneyReleaseDate;
    @JsonProperty("money_release_schema")
    private String moneyReleaseSchema;
    @JsonProperty("money_release_status")
    private String moneyReleaseStatus;
    @JsonProperty("notification_url")
    private String notificationUrl;
    @JsonProperty("operation_type")
    private String operationType;
    private Order order;
    private Payer payer;
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("payment_type_id")
    private String paymentTypeId;
    @JsonProperty("platform_id")
    private String platformId;
    @JsonProperty("point_of_interaction")
    private PointOfInteraction pointOfInteraction;
    @JsonProperty("pos_id")
    private String posId;
    @JsonProperty("processing_mode")
    private String processingMode;
    private List<String> refunds;
    @JsonProperty("shipping_amount")
    private int shippingAmount;
    @JsonProperty("sponsor_id")
    private String sponsorId;
    @JsonProperty("statement_descriptor")
    private String statementDescriptor;
    private String status;
    @JsonProperty("status_detail")
    private String statusDetail;
    @JsonProperty("store_id")
    private String storeId;
    @JsonProperty("taxes_amount")
    private int taxesAmount;
    @JsonProperty("transaction_amount")
    private int transactionAmount;
    @JsonProperty("transaction_amount_refunded")
    private int transactionAmountRefunded;
    @JsonProperty("transaction_details")
    private TransactionDetails transactionDetails;
    public void setAcquirerReconciliation(List<String> acquirerReconciliation) {
         this.acquirerReconciliation = acquirerReconciliation;
     }
     public List<String> getAcquirerReconciliation() {
         return acquirerReconciliation;
     }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
         this.additionalInfo = additionalInfo;
     }
     public AdditionalInfo getAdditionalInfo() {
         return additionalInfo;
     }

    public void setAuthorizationCode(String authorizationCode) {
         this.authorizationCode = authorizationCode;
     }
     public String getAuthorizationCode() {
         return authorizationCode;
     }

    public void setBarcode(Barcode barcode) {
         this.barcode = barcode;
     }
     public Barcode getBarcode() {
         return barcode;
     }

    public void setBinaryMode(boolean binaryMode) {
         this.binaryMode = binaryMode;
     }
     public boolean getBinaryMode() {
         return binaryMode;
     }

    public void setBrandId(String brandId) {
         this.brandId = brandId;
     }
     public String getBrandId() {
         return brandId;
     }

    public void setBuildVersion(String buildVersion) {
         this.buildVersion = buildVersion;
     }
     public String getBuildVersion() {
         return buildVersion;
     }

    public void setCallForAuthorizeId(String callForAuthorizeId) {
         this.callForAuthorizeId = callForAuthorizeId;
     }
     public String getCallForAuthorizeId() {
         return callForAuthorizeId;
     }

    public void setCaptured(boolean captured) {
         this.captured = captured;
     }
     public boolean getCaptured() {
         return captured;
     }

    public void setCard(Card card) {
         this.card = card;
     }
     public Card getCard() {
         return card;
     }

    public void setChargesDetails(List<String> chargesDetails) {
         this.chargesDetails = chargesDetails;
     }
     public List<String> getChargesDetails() {
         return chargesDetails;
     }

    public void setCollectorId(int collectorId) {
         this.collectorId = collectorId;
     }
     public int getCollectorId() {
         return collectorId;
     }

    public void setCorporationId(String corporationId) {
         this.corporationId = corporationId;
     }
     public String getCorporationId() {
         return corporationId;
     }

    public void setCounterCurrency(String counterCurrency) {
         this.counterCurrency = counterCurrency;
     }
     public String getCounterCurrency() {
         return counterCurrency;
     }

    public void setCouponAmount(int couponAmount) {
         this.couponAmount = couponAmount;
     }
     public int getCouponAmount() {
         return couponAmount;
     }

    public void setCurrencyId(String currencyId) {
         this.currencyId = currencyId;
     }
     public String getCurrencyId() {
         return currencyId;
     }

    public void setDateApproved(String dateApproved) {
         this.dateApproved = dateApproved;
     }
     public String getDateApproved() {
         return dateApproved;
     }

    public void setDateCreated(Date dateCreated) {
         this.dateCreated = dateCreated;
     }
     public Date getDateCreated() {
         return dateCreated;
     }

    public void setDateLastUpdated(Date dateLastUpdated) {
         this.dateLastUpdated = dateLastUpdated;
     }
     public Date getDateLastUpdated() {
         return dateLastUpdated;
     }

    public void setDateOfExpiration(Date dateOfExpiration) {
         this.dateOfExpiration = dateOfExpiration;
     }
     public Date getDateOfExpiration() {
         return dateOfExpiration;
     }

    public void setDeductionSchema(String deductionSchema) {
         this.deductionSchema = deductionSchema;
     }
     public String getDeductionSchema() {
         return deductionSchema;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setDifferentialPricingId(String differentialPricingId) {
         this.differentialPricingId = differentialPricingId;
     }
     public String getDifferentialPricingId() {
         return differentialPricingId;
     }

    public void setExternalReference(String externalReference) {
         this.externalReference = externalReference;
     }
     public String getExternalReference() {
         return externalReference;
     }

    public void setFeeDetails(List<String> feeDetails) {
         this.feeDetails = feeDetails;
     }
     public List<String> getFeeDetails() {
         return feeDetails;
     }

    public void setFinancingGroup(String financingGroup) {
         this.financingGroup = financingGroup;
     }
     public String getFinancingGroup() {
         return financingGroup;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setInstallments(int installments) {
         this.installments = installments;
     }
     public int getInstallments() {
         return installments;
     }

    public void setIntegratorId(String integratorId) {
         this.integratorId = integratorId;
     }
     public String getIntegratorId() {
         return integratorId;
     }

    public void setIssuerId(String issuerId) {
         this.issuerId = issuerId;
     }
     public String getIssuerId() {
         return issuerId;
     }

    public void setLiveMode(boolean liveMode) {
         this.liveMode = liveMode;
     }
     public boolean getLiveMode() {
         return liveMode;
     }

    public void setMarketplaceOwner(String marketplaceOwner) {
         this.marketplaceOwner = marketplaceOwner;
     }
     public String getMarketplaceOwner() {
         return marketplaceOwner;
     }

    public void setMerchantAccountId(String merchantAccountId) {
         this.merchantAccountId = merchantAccountId;
     }
     public String getMerchantAccountId() {
         return merchantAccountId;
     }

    public void setMerchantNumber(String merchantNumber) {
         this.merchantNumber = merchantNumber;
     }
     public String getMerchantNumber() {
         return merchantNumber;
     }

    public void setMetadata(Metadata metadata) {
         this.metadata = metadata;
     }
     public Metadata getMetadata() {
         return metadata;
     }

    public void setMoneyReleaseDate(String moneyReleaseDate) {
         this.moneyReleaseDate = moneyReleaseDate;
     }
     public String getMoneyReleaseDate() {
         return moneyReleaseDate;
     }

    public void setMoneyReleaseSchema(String moneyReleaseSchema) {
         this.moneyReleaseSchema = moneyReleaseSchema;
     }
     public String getMoneyReleaseSchema() {
         return moneyReleaseSchema;
     }

    public void setMoneyReleaseStatus(String moneyReleaseStatus) {
         this.moneyReleaseStatus = moneyReleaseStatus;
     }
     public String getMoneyReleaseStatus() {
         return moneyReleaseStatus;
     }

    public void setNotificationUrl(String notificationUrl) {
         this.notificationUrl = notificationUrl;
     }
     public String getNotificationUrl() {
         return notificationUrl;
     }

    public void setOperationType(String operationType) {
         this.operationType = operationType;
     }
     public String getOperationType() {
         return operationType;
     }

    public void setOrder(Order order) {
         this.order = order;
     }
     public Order getOrder() {
         return order;
     }

    public void setPayer(Payer payer) {
         this.payer = payer;
     }
     public Payer getPayer() {
         return payer;
     }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
         this.paymentMethod = paymentMethod;
     }
     public PaymentMethod getPaymentMethod() {
         return paymentMethod;
     }

    public void setPaymentMethodId(String paymentMethodId) {
         this.paymentMethodId = paymentMethodId;
     }
     public String getPaymentMethodId() {
         return paymentMethodId;
     }

    public void setPaymentTypeId(String paymentTypeId) {
         this.paymentTypeId = paymentTypeId;
     }
     public String getPaymentTypeId() {
         return paymentTypeId;
     }

    public void setPlatformId(String platformId) {
         this.platformId = platformId;
     }
     public String getPlatformId() {
         return platformId;
     }

    public void setPointOfInteraction(PointOfInteraction pointOfInteraction) {
         this.pointOfInteraction = pointOfInteraction;
     }
     public PointOfInteraction getPointOfInteraction() {
         return pointOfInteraction;
     }

    public void setPosId(String posId) {
         this.posId = posId;
     }
     public String getPosId() {
         return posId;
     }

    public void setProcessingMode(String processingMode) {
         this.processingMode = processingMode;
     }
     public String getProcessingMode() {
         return processingMode;
     }

    public void setRefunds(List<String> refunds) {
         this.refunds = refunds;
     }
     public List<String> getRefunds() {
         return refunds;
     }

    public void setShippingAmount(int shippingAmount) {
         this.shippingAmount = shippingAmount;
     }
     public int getShippingAmount() {
         return shippingAmount;
     }

    public void setSponsorId(String sponsorId) {
         this.sponsorId = sponsorId;
     }
     public String getSponsorId() {
         return sponsorId;
     }

    public void setStatementDescriptor(String statementDescriptor) {
         this.statementDescriptor = statementDescriptor;
     }
     public String getStatementDescriptor() {
         return statementDescriptor;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setStatusDetail(String statusDetail) {
         this.statusDetail = statusDetail;
     }
     public String getStatusDetail() {
         return statusDetail;
     }

    public void setStoreId(String storeId) {
         this.storeId = storeId;
     }
     public String getStoreId() {
         return storeId;
     }

    public void setTaxesAmount(int taxesAmount) {
         this.taxesAmount = taxesAmount;
     }
     public int getTaxesAmount() {
         return taxesAmount;
     }

    public void setTransactionAmount(int transactionAmount) {
         this.transactionAmount = transactionAmount;
     }
     public int getTransactionAmount() {
         return transactionAmount;
     }

    public void setTransactionAmountRefunded(int transactionAmountRefunded) {
         this.transactionAmountRefunded = transactionAmountRefunded;
     }
     public int getTransactionAmountRefunded() {
         return transactionAmountRefunded;
     }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
         this.transactionDetails = transactionDetails;
     }
     public TransactionDetails getTransactionDetails() {
         return transactionDetails;
     }

}