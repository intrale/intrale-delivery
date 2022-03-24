package ar.com.intrale.functions;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import ar.com.intrale.BaseFunction;
import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.Response;
import ar.com.intrale.exceptions.FunctionException;
import ar.com.intrale.messages.DeleteDeliveryLocationRequest;
import ar.com.intrale.messages.builders.StringToDeleteDeliveryLocationRequestBuilder;

@Singleton
@Named(DeleteDeliveryLocationFunction.FUNCTION_NAME)
public class DeleteDeliveryLocationFunction extends BaseFunction<DeleteDeliveryLocationRequest, Response, AmazonDynamoDB, StringToDeleteDeliveryLocationRequestBuilder, FunctionResponseToBase64HttpResponseBuilder> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteDeliveryLocationFunction.class);
	
	public static final String TABLE_NAME 		= "deliveryLocation";
	
    public static final String ID 		= "deliveryLocationId";
	
    public static final String FUNCTION_NAME = "DeleteDeliveryLocation";
    
	@Override
	public Response execute(DeleteDeliveryLocationRequest request) throws FunctionException {
		
		Map<String, AttributeValue> key = new HashMap<String, AttributeValue>();
		key.put(ID, new AttributeValue(request.getDeliveryLocationId()));
		
		provider.deleteItem(TABLE_NAME, key);
	   
       return new Response();
	}
}
