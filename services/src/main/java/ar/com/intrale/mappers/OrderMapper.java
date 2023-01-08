package ar.com.intrale.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import ar.com.intrale.client.ProductClient;
import ar.com.intrale.exceptions.ClientResponseException;
import ar.com.intrale.messages.OrderMessage;
import ar.com.intrale.messages.OrderProductMessage;
import ar.com.intrale.messages.ProductMessage;
import ar.com.intrale.messages.ReadProductRequest;
import ar.com.intrale.messages.ReadProductResponse;
import ar.com.intrale.messages.SaveOrderRequest;
import ar.com.intrale.models.DeliveryLocation;
import ar.com.intrale.models.Order;
import ar.com.intrale.models.OrderProduct;

@Mapper
public abstract class OrderMapper {
	
	private ProductClient productClient;
	
	private AmazonDynamoDB provider;

	public AmazonDynamoDB getProvider() {
		return provider;
	}

	public void setProvider(AmazonDynamoDB provider) {
		this.provider = provider;
	}

	public ProductClient getProductClient() {
		return productClient;
	}

	public void setProductClient(ProductClient productClient) {
		this.productClient = productClient;
	}

	@Mappings({
	      @Mapping(target="id", source="orderId"),
	    })
	public abstract Order requestToModel(SaveOrderRequest request);
	public abstract OrderMessage modelToRequest(Order order);
	
	public DeliveryLocation idToDeliveryLocation(String deliveryLocation) {
		DynamoDBMapper mapper = new DynamoDBMapper(provider);
		return mapper.load(DeliveryLocation.class, deliveryLocation);
	}
	
	public String deliveryLocationToId(DeliveryLocation deliveryLocation) {
		return deliveryLocation.getDeliveryLocationId();
	}
	
	public OrderProduct productMessageToProduct(OrderProductMessage orderProductMessage) throws JsonMappingException, JsonProcessingException, ClientResponseException {
		ReadProductRequest readProductRequest = new ReadProductRequest();
		readProductRequest.setRequestId(orderProductMessage.getRequestId());
		readProductRequest.setProductId(orderProductMessage.getProductId());
		ReadProductResponse readProductResponse = productClient.read(orderProductMessage.getRequestRoot().getBusinessName(), readProductRequest); 
		ProductMessage productMessage = readProductResponse.getProducts().iterator().next();
		OrderProduct orderProduct = ProductMapper.INSTANCE.requestToModel(productMessage);
		orderProduct.setProductId(orderProductMessage.getProductId());
		orderProduct.setCount(orderProductMessage.getCount());
		return orderProduct;
	}
	
	
	
}
