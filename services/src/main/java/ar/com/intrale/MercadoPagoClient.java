package ar.com.intrale;

import javax.validation.constraints.NotBlank;

import org.reactivestreams.Publisher;

import ar.com.intrale.messages.mercadopago.Payment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;

@Client("https://api.mercadopago.com/")
@Header(name = "Authorization", value = "Bearer TEST-1312279043000238-022814-1d748dae4d4bd2c7a8a1b7a0e6044fe7-83892950")
public interface MercadoPagoClient {

	@Get("v1/payments/{paymentId}") 
    Publisher<Payment> getPayment(@NotBlank String paymentId); 
	
}
