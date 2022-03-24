package ar.com.intrale.cloud.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import ar.com.intrale.IntraleFactory;
import ar.com.intrale.functions.DeleteDeliveryLocationFunction;
import ar.com.intrale.functions.ReadOrderFunction;
import ar.com.intrale.functions.SaveDeliveryLocationFunction;
import ar.com.intrale.functions.SaveOrderFunction;
import ar.com.intrale.messages.DeleteDeliveryLocationRequest;
import ar.com.intrale.messages.DeleteProductRequest;
import ar.com.intrale.messages.OrderProductMessage;
import ar.com.intrale.messages.PriceMessage;
import ar.com.intrale.messages.ReadOrderRequest;
import ar.com.intrale.messages.ReadOrderResponse;
import ar.com.intrale.messages.SaveDeliveryLocationRequest;
import ar.com.intrale.messages.SaveDeliveryLocationResponse;
import ar.com.intrale.messages.SaveOrderRequest;
import ar.com.intrale.messages.SaveOrderResponse;
import ar.com.intrale.messages.SaveProductRequest;
import ar.com.intrale.messages.SaveProductResponse;
import ar.com.intrale.services.ProductClient;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.annotation.MicronautTest;


@MicronautTest(rebuildContext = true)
@Property(name = IntraleFactory.FACTORY, value = "true")
@Property(name = IntraleFactory.PROVIDER, value = "true")
public class OrderIntegrationTest extends ar.com.intrale.Test {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderIntegrationTest.class);

	@Inject
	private ProductClient productClient;
	
	
	@Override
    public void beforeEach() {
    }
	
	@Override
	public void afterEach() {
	}
    
    @Test
    public void test() throws Exception {
    	
    	LOGGER.info("Guardando Delivery Location");
    	SaveDeliveryLocationRequest request = new SaveDeliveryLocationRequest();
    	request.setRequestId(DUMMY_VALUE);
    	request.setBusinessName(DUMMY_VALUE);
    	request.setCountry(DUMMY_VALUE);
    	request.setDetails(DUMMY_VALUE);
    	request.setEmail(DUMMY_EMAIL);
    	request.setLocation(DUMMY_VALUE);
    	request.setNumber(DUMMY_VALUE);
    	request.setPostalCode(DUMMY_VALUE);
    	request.setRegion(DUMMY_VALUE);
    	request.setStreet(DUMMY_VALUE);
    	
    	APIGatewayProxyResponseEvent responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(request, SaveDeliveryLocationFunction.FUNCTION_NAME));
        SaveDeliveryLocationResponse saveDeliveryLocationResponse  = readEncodedValue(responseEvent.getBody(), SaveDeliveryLocationResponse.class);
    	
    	LOGGER.info("Guardando producto");
    	// Crear un producto con su precio y guardarlo
    	SaveProductRequest saveProductRequest = new SaveProductRequest();
    	saveProductRequest.setRequestId(DUMMY_VALUE);
    	saveProductRequest.setCategory(DUMMY_VALUE);
    	saveProductRequest.setDescription(DUMMY_VALUE);
    	saveProductRequest.setName(DUMMY_VALUE);
    	saveProductRequest.setCategory(DUMMY_VALUE);
    	PriceMessage priceMessage = new PriceMessage();
    	priceMessage.setCurrencyAcronym(DUMMY_VALUE);
    	priceMessage.setUnitPrice(Double.valueOf(1));
    	saveProductRequest.setPrice(priceMessage);
    	
    	LOGGER.info("Invocando productClient save");
    	SaveProductResponse saveProductResponse = productClient.save(DUMMY_VALUE, saveProductRequest);
    	LOGGER.info("Retorno productClient save");    	
	
    	
    	SaveOrderRequest orderRequest = new SaveOrderRequest();
    	orderRequest.setRequestId(DUMMY_VALUE);
    	orderRequest.setEmail(DUMMY_EMAIL);
    	orderRequest.setDeliveryLocation(saveDeliveryLocationResponse.getDeliveryLocation());
    	
    	OrderProductMessage product = new OrderProductMessage();
    	// el productId tiene que ser el del producto generado arriba
    	product.setProductId(saveProductResponse.getProductId());
    	product.setCount(Long.valueOf(2));
    	
    	Collection<OrderProductMessage> products = new ArrayList<OrderProductMessage>();
    	products.add(product);
    	
    	orderRequest.setProducts(products);
    	
    	LOGGER.info("Guardando orden");
    	responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(orderRequest, SaveOrderFunction.FUNCTION_NAME));
    	SaveOrderResponse orderResponse  = readEncodedValue(responseEvent.getBody(), SaveOrderResponse.class);
        
        assertEquals(200, orderResponse.getStatusCode());
        
        LOGGER.info("Leyendo orden");
        ReadOrderRequest readOrderRequest = new ReadOrderRequest();
        readOrderRequest.setRequestId(DUMMY_VALUE);
        readOrderRequest.setOrderId(orderResponse.getOrderId());
        
        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(readOrderRequest, ReadOrderFunction.FUNCTION_NAME));
        ReadOrderResponse readOrderResponse  = readEncodedValue(responseEvent.getBody(), ReadOrderResponse.class);
        
        assertEquals(200, readOrderResponse.getStatusCode());
        assertTrue(readOrderResponse.getFindings().size()==1);
    	
        LOGGER.info("Eliminando producto");
        DeleteProductRequest deleteProductRequest = new DeleteProductRequest();
        deleteProductRequest.setRequestId(DUMMY_VALUE);
        deleteProductRequest.setProductId(saveProductResponse.getProductId());
        productClient.delete(DUMMY_VALUE, deleteProductRequest);
        
        LOGGER.info("Eliminando Delivery Location");
        DeleteDeliveryLocationRequest deleteDeliveryLocationRequest = new DeleteDeliveryLocationRequest();
        deleteDeliveryLocationRequest.setRequestId(DUMMY_VALUE);
        deleteDeliveryLocationRequest.setDeliveryLocationId(saveDeliveryLocationResponse.getDeliveryLocation());
        
        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(deleteDeliveryLocationRequest, DeleteDeliveryLocationFunction.FUNCTION_NAME));
        assertEquals(200, responseEvent.getStatusCode());
    }
}
