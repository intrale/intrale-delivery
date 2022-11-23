package ar.com.intrale.messages.builders;

import javax.inject.Singleton;

import ar.com.intrale.StringToAnyRequestBuilder;
import ar.com.intrale.messages.MercadoPagoNotificationEventRequest;
import ar.com.intrale.messages.MercadoPagoNotificationRequest;

@Singleton
public class StringToMercadoPagoNotificationRequestBuilder extends StringToAnyRequestBuilder<MercadoPagoNotificationRequest, MercadoPagoNotificationEventRequest> {

}
