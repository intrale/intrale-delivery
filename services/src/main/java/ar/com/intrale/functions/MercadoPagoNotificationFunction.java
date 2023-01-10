	package ar.com.intrale.functions;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.fasterxml.jackson.core.JsonProcessingException;

import ar.com.intrale.BaseFunction;
import ar.com.intrale.FunctionConst;
import ar.com.intrale.FunctionResponseToBase64HttpResponseBuilder;
import ar.com.intrale.MercadoPagoClient;
import ar.com.intrale.exceptions.FunctionException;
import ar.com.intrale.messages.MercadoPagoNotificationActionRequest;
import ar.com.intrale.messages.MercadoPagoNotificationRequest;
import ar.com.intrale.messages.Response;
import ar.com.intrale.messages.builders.StringToMercadoPagoNotificationRequestBuilder;
import ar.com.intrale.messages.mercadopago.Payment;

@Singleton
@Named(FunctionConst.READ)
public class MercadoPagoNotificationFunction extends BaseFunction<MercadoPagoNotificationRequest, Response, AmazonDynamoDB, StringToMercadoPagoNotificationRequestBuilder, FunctionResponseToBase64HttpResponseBuilder> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MercadoPagoNotificationFunction.class);
	
    @Inject
	private MercadoPagoClient mercadoPagoClient;
	
	@Override
	public Response execute(MercadoPagoNotificationRequest request) throws FunctionException {
		try {
			LOGGER.info("MercadoPagoNotificationRequest:" + mapper.writeValueAsString(request));
			
			if (request instanceof MercadoPagoNotificationActionRequest) {
				MercadoPagoNotificationActionRequest notifictionRequest = (MercadoPagoNotificationActionRequest) request;
				
				mercadoPagoClient.getPayment(notifictionRequest.getData().getId()).subscribe(new Subscriber<Payment>() {

					@Override
					public void onSubscribe(Subscription s) {
					}

					@Override
					public void onNext(Payment payment) {
						try {
							LOGGER.info("Payment:" + mapper.writeValueAsString(payment));
						} catch (JsonProcessingException e) {
							LOGGER.error(FunctionException.toString(e));						
						}
					}

					@Override
					public void onError(Throwable t) {
						LOGGER.error(FunctionException.toString(t));
					}

					@Override
					public void onComplete() {
						LOGGER.info("mercadoPagoClient call complete");
					}
				});
				
				
			}
			
		} catch (JsonProcessingException e) {
			LOGGER.error(FunctionException.toString(e));
		}
		return new Response();
	}

}
