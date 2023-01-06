package ar.com.intrale.messages.builders;

import javax.inject.Singleton;

import ar.com.intrale.StringToAnyRequestBuilder;
import ar.com.intrale.messages.MercadoPagoNotificationActionRequest;
import ar.com.intrale.messages.MercadoPagoNotificationEventRequest;
import ar.com.intrale.messages.MercadoPagoNotificationOrderRequest;

@Singleton
public class StringToMercadoPagoNotificationRequestBuilder extends StringToAnyRequestBuilder<MercadoPagoNotificationActionRequest, MercadoPagoNotificationOrderRequest, MercadoPagoNotificationEventRequest> {

}
