package ar.com.intrale.messages.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails {

    @JsonProperty("acquirer_reference")
    private String acquirerReference;
    @JsonProperty("external_resource_url")
    private String externalResourceUrl;
    @JsonProperty("financial_institution")
    private String financialInstitution;
    @JsonProperty("installment_amount")
    private int installmentAmount;
    @JsonProperty("net_received_amount")
    private int netReceivedAmount;
    @JsonProperty("overpaid_amount")
    private int overpaidAmount;
    @JsonProperty("payable_deferral_period")
    private String payableDeferralPeriod;
    @JsonProperty("payment_method_reference_id")
    private String paymentMethodReferenceId;
    @JsonProperty("total_paid_amount")
    private int totalPaidAmount;
    @JsonProperty("verification_code")
    private String verificationCode;
    public void setAcquirerReference(String acquirerReference) {
         this.acquirerReference = acquirerReference;
     }
     public String getAcquirerReference() {
         return acquirerReference;
     }

    public void setExternalResourceUrl(String externalResourceUrl) {
         this.externalResourceUrl = externalResourceUrl;
     }
     public String getExternalResourceUrl() {
         return externalResourceUrl;
     }

    public void setFinancialInstitution(String financialInstitution) {
         this.financialInstitution = financialInstitution;
     }
     public String getFinancialInstitution() {
         return financialInstitution;
     }

    public void setInstallmentAmount(int installmentAmount) {
         this.installmentAmount = installmentAmount;
     }
     public int getInstallmentAmount() {
         return installmentAmount;
     }

    public void setNetReceivedAmount(int netReceivedAmount) {
         this.netReceivedAmount = netReceivedAmount;
     }
     public int getNetReceivedAmount() {
         return netReceivedAmount;
     }

    public void setOverpaidAmount(int overpaidAmount) {
         this.overpaidAmount = overpaidAmount;
     }
     public int getOverpaidAmount() {
         return overpaidAmount;
     }

    public void setPayableDeferralPeriod(String payableDeferralPeriod) {
         this.payableDeferralPeriod = payableDeferralPeriod;
     }
     public String getPayableDeferralPeriod() {
         return payableDeferralPeriod;
     }

    public void setPaymentMethodReferenceId(String paymentMethodReferenceId) {
         this.paymentMethodReferenceId = paymentMethodReferenceId;
     }
     public String getPaymentMethodReferenceId() {
         return paymentMethodReferenceId;
     }

    public void setTotalPaidAmount(int totalPaidAmount) {
         this.totalPaidAmount = totalPaidAmount;
     }
     public int getTotalPaidAmount() {
         return totalPaidAmount;
     }

    public void setVerificationCode(String verificationCode) {
         this.verificationCode = verificationCode;
     }
     public String getVerificationCode() {
         return verificationCode;
     }

}