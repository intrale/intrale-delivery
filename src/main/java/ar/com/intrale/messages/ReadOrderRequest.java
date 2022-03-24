package ar.com.intrale.messages;

import ar.com.intrale.RequestRoot;

public class ReadOrderRequest extends RequestRoot {

	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}
