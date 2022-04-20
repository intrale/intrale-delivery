package ar.com.intrale.functions;

import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import ar.com.intrale.BaseFunction;
import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.exceptions.FunctionException;
import ar.com.intrale.mappers.DeliveryLocationMapper;
import ar.com.intrale.messages.SaveDeliveryLocationRequest;
import ar.com.intrale.messages.SaveDeliveryLocationResponse;
import ar.com.intrale.messages.builders.StringToSaveDeliveryLocationRequestBuilder;
import ar.com.intrale.models.DeliveryLocation;

@Singleton
@Named(SaveDeliveryLocationFunction.FUNCTION_NAME)
public class SaveDeliveryLocationFunction extends BaseFunction<SaveDeliveryLocationRequest, SaveDeliveryLocationResponse, AmazonDynamoDB, StringToSaveDeliveryLocationRequestBuilder, FunctionResponseToBase64HttpResponseBuilder> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaveDeliveryLocationFunction.class);
	
	public static final String FUNCTION_NAME = "SaveDeliveryLocation";

	@Override
	public SaveDeliveryLocationResponse execute(SaveDeliveryLocationRequest request) throws FunctionException {
		SaveDeliveryLocationResponse response = new SaveDeliveryLocationResponse();
		
		LOGGER.info("Inicializando AddDeliveryLocation");
		
		DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(provider);
		
		DeliveryLocation deliveryLocation = DeliveryLocationMapper.INSTANCE.requestToModel(request);
		dynamoDBMapper.save(deliveryLocation);

		response.setDeliveryLocation(deliveryLocation.getDeliveryLocationId());
	   LOGGER.info("Finalizando AddDeliveryLocation");
	   
       return response;
	}

}
