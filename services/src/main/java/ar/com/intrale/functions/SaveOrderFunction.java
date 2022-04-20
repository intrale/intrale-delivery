package ar.com.intrale.functions;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ar.com.intrale.BaseFunction;
import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.exceptions.FunctionException;
import ar.com.intrale.mappers.OrderMapper;
import ar.com.intrale.messages.SaveOrderRequest;
import ar.com.intrale.messages.SaveOrderResponse;
import ar.com.intrale.messages.builders.StringToSaveOrderRequestBuilder;
import ar.com.intrale.models.Order;

@Singleton
@Named(SaveOrderFunction.FUNCTION_NAME)
public class SaveOrderFunction extends BaseFunction<SaveOrderRequest, SaveOrderResponse, AmazonDynamoDB, StringToSaveOrderRequestBuilder, FunctionResponseToBase64HttpResponseBuilder> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveOrderFunction.class);
	
	public static final String FUNCTION_NAME = "SaveOrder";

	@Inject
	private OrderMapper orderMapper;
	
	@Override
	public SaveOrderResponse execute(SaveOrderRequest request) throws FunctionException {
		SaveOrderResponse response = new SaveOrderResponse();
		
		LOGGER.info("Inicializando AddDeliveryLocation");
		
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(provider);
		
		Order order = orderMapper.requestToModel(request);
		order.setOrderStatus("CREATED");
	
		dynamoDBMapper.save(order);
		
		response.setOrderId(order.getOrderId());
	   LOGGER.info("Finalizando AddDeliveryLocation");
	   
       return response;
	}

}
