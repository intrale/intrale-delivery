package ar.com.intrale.models;

import java.util.Collection;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName="order")
public class Order {

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String orderId;

	private String businessName;
	private String email;
	
	private String orderStatus;
	
	private DeliveryLocation deliveryLocation;
	
	@DynamoDBTypeConverted(converter = OrderProductToJsonConverter.class)
	private Collection<OrderProduct> products;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public DeliveryLocation getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(DeliveryLocation deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public Collection<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(Collection<OrderProduct> products) {
		this.products = products;
	}
	
	
}