package ar.com.intrale.functions;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.ReadBaseFunction;
import ar.com.intrale.mappers.OrderMapper;
import ar.com.intrale.messages.ReadOrderRequest;
import ar.com.intrale.messages.ReadOrderResponse;
import ar.com.intrale.messages.builders.StringToReadOrderRequestBuilder;
import ar.com.intrale.models.Order;
import io.micronaut.core.util.StringUtils;

@Singleton
@Named(ReadOrderFunction.FUNCTION_NAME)
public class ReadOrderFunction extends 
ReadBaseFunction <ReadOrderRequest, ReadOrderResponse, AmazonDynamoDB, StringToReadOrderRequestBuilder, FunctionResponseToBase64HttpResponseBuilder, Order> {

	public static final String FUNCTION_NAME = "ReadOrder";
	
	@Inject
	private OrderMapper orderMapper;
	
	@Override
	protected Object modelToRequest(Order entity) {
		return orderMapper.modelToRequest(entity);
	}

	@Override
	protected Boolean isNeedsToBeFiltered(ReadOrderRequest request, Order entity) {
		Boolean idFilter = (!StringUtils.isEmpty(request.getOrderId()) && !entity.getId().equals(request.getOrderId()));
		Boolean needsToBeFiltered = (idFilter);
		return needsToBeFiltered;
	}
	

}
