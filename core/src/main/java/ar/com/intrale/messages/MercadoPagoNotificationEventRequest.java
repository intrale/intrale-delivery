package ar.com.intrale.messages;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
/**
 * {"resource":"https://api.mercadolibre.com/merchant_orders/12734730348","topic":"merchant_order"}
 */
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


	@Override
	public String getBusinessName() {
		return super.getBusinessName();
	}
}
