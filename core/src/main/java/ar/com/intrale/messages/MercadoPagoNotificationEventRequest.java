package ar.com.intrale.messages;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class MercadoPagoNotificationEventRequest extends MercadoPagoNotificationRequest {
	private String resource;
	private String topic;
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
		setRequestId(resource);
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
	
}
