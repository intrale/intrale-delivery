package ar.com.intrale.messages;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ReadDeliveryLocationRequest extends RequestRoot {
	
	private String deliveryLocationId;

	public String getDeliveryLocationId() {
		return deliveryLocationId;
	}

	public void setDeliveryLocationId(String deliveryLocationId) {
		this.deliveryLocationId = deliveryLocationId;
	}

}
