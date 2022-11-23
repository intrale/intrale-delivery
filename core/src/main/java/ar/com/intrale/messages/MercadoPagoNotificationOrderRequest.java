package ar.com.intrale.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
  "description": ".....",
  "merchant_order": 4945357007,
  "payment_id": 23064274473
 */
public class MercadoPagoNotificationOrderRequest extends MercadoPagoNotificationRequest {
	private String merchantOrder;
	private String paymentId;
	private String description;
	
	@JsonProperty("merchant_order")
	public String getMerchantOrder() {
		return merchantOrder;
	}
	public void setMerchantOrder(String merchantOrder) {
		this.merchantOrder = merchantOrder;
	}
	
	@JsonProperty("payment_id")
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
		setRequestId(paymentId);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
