package ar.com.intrale.messages;

import ar.com.intrale.RequestRoot;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class DeleteDeliveryLocationRequest extends RequestRoot {
	
	private String deliveryLocationId;

	public String getDeliveryLocationId() {
		return deliveryLocationId;
	}

	public void setDeliveryLocationId(String deliveryLocationId) {
		this.deliveryLocationId = deliveryLocationId;
	}
	
}
