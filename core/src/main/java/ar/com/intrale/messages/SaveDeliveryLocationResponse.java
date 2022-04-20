package ar.com.intrale.messages;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class SaveDeliveryLocationResponse extends Response {
	
	private String deliveryLocation;

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	
}
