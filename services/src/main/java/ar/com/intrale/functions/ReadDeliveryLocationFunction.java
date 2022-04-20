package ar.com.intrale.functions;

import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.ReadBaseFunction;
import ar.com.intrale.mappers.DeliveryLocationMapper;
import ar.com.intrale.messages.ReadDeliveryLocationRequest;
import ar.com.intrale.messages.ReadDeliveryLocationResponse;
import ar.com.intrale.messages.builders.StringToReadDeliveryLocationRequestBuilder;
import ar.com.intrale.models.DeliveryLocation;
import io.micronaut.core.util.StringUtils;

@Singleton
@Named(ReadDeliveryLocationFunction.FUNCTION_NAME)
public class ReadDeliveryLocationFunction extends 
ReadBaseFunction <ReadDeliveryLocationRequest, ReadDeliveryLocationResponse, AmazonDynamoDB, StringToReadDeliveryLocationRequestBuilder, FunctionResponseToBase64HttpResponseBuilder, DeliveryLocation> {
	
	public static final String FUNCTION_NAME = "ReadDeliveryLocation";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadDeliveryLocationFunction.class);
	/**
	 * Retorna verdadero si necesita ser filtrado y NO retornado junto con el response
	 * @param request
	 * @param deliveryLocation
	 * @return
	 */
	@Override
	protected Boolean isNeedsToBeFiltered(ReadDeliveryLocationRequest request, DeliveryLocation deliveryLocation) {
		Boolean deliveryLocationIdFilter = (!StringUtils.isEmpty(request.getDeliveryLocationId()) && !deliveryLocation.getDeliveryLocationId().equals(request.getDeliveryLocationId()));
		Boolean needsToBeFiltered = (deliveryLocationIdFilter);
		return needsToBeFiltered;
	}

	@Override
	protected Object modelToRequest(DeliveryLocation entity) {
		return DeliveryLocationMapper.INSTANCE.modelToRequest(entity);
	}

}
