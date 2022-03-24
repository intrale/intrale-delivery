package ar.com.intrale.messages;

import java.util.Collection;

import ar.com.intrale.RequestChild;

public class OrderMessage extends RequestChild {
	private String orderId;

	private String email;
	
	private Collection<OrderProductMessage> products;
	
	private String deliveryLocation;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<OrderProductMessage> getProducts() {
		return products;
	}

	public void setProducts(Collection<OrderProductMessage> products) {
		this.products = products;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
}
