package ar.com.intrale.functions;

import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.fasterxml.jackson.core.JsonProcessingException;

import ar.com.intrale.BaseFunction;
import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.exceptions.FunctionException;
import ar.com.intrale.messages.MercadoPagoWHRequest;
import ar.com.intrale.messages.Response;
import ar.com.intrale.messages.builders.StringToMercadoPagoWHRequestBuilder;

@Singleton
@Named(DeleteDeliveryLocationFunction.FUNCTION_NAME)
public class MercadoPagoWHFunction extends BaseFunction<MercadoPagoWHRequest, Response, AmazonDynamoDB, StringToMercadoPagoWHRequestBuilder, FunctionResponseToBase64HttpResponseBuilder> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MercadoPagoWHFunction.class);
	
	@Override
	public Response execute(MercadoPagoWHRequest request) throws FunctionException {
		try {
			LOGGER.info("MercadoPagoWHRequest:" + mapper.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			LOGGER.error(FunctionException.toString(e));
		}
		return new Response();
	}

}
