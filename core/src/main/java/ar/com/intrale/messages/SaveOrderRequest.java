package ar.com.intrale.messages;

import java.util.Collection;

import javax.validation.constraints.NotBlank;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class SaveOrderRequest extends RequestRoot {
	
	private String orderId;

	@NonNull
    @NotBlank
	private String email;
	
	private Collection<OrderProductMessage> products;
	
	private String deliveryLocation;
	
	private Integer collectorId;
	
	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

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
		setRootOnCollection(products);
		this.products = products;
	}

	
	public Integer getCollectorId() {
		return collectorId;
	}
	public void setCollectorId(Integer collectorId) {
		this.collectorId = collectorId;
	}	
}
