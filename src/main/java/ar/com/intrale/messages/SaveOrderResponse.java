package ar.com.intrale.messages;

import ar.com.intrale.Response;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class SaveOrderResponse extends Response {
	
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
