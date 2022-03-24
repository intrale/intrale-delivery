package ar.com.intrale.cloud.test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import ar.com.intrale.IntraleFactory;
import ar.com.intrale.functions.DeleteDeliveryLocationFunction;
import ar.com.intrale.functions.ReadDeliveryLocationFunction;
import ar.com.intrale.functions.SaveDeliveryLocationFunction;
import ar.com.intrale.messages.DeleteDeliveryLocationRequest;
import ar.com.intrale.messages.ReadDeliveryLocationRequest;
import ar.com.intrale.messages.ReadDeliveryLocationResponse;
import ar.com.intrale.messages.SaveDeliveryLocationRequest;
import ar.com.intrale.messages.SaveDeliveryLocationResponse;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.annotation.MicronautTest;


@MicronautTest(rebuildContext = true)
@Property(name = IntraleFactory.FACTORY, value = "true")
@Property(name = IntraleFactory.PROVIDER, value = "true")
public class DeliveryIntegrationTest extends ar.com.intrale.Test {
	
	@Override
    public void beforeEach() {
    }
	
	@Override
	public void afterEach() {
	}
    
    @Test
    public void test() throws Exception {
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
        SaveDeliveryLocationResponse createDeliveryLocationResponse  = readEncodedValue(responseEvent.getBody(), SaveDeliveryLocationResponse.class);
        
        assertEquals(200, createDeliveryLocationResponse.getStatusCode());
        
        ReadDeliveryLocationRequest readDeliveryLocationRequest = new ReadDeliveryLocationRequest();
        readDeliveryLocationRequest.setRequestId(DUMMY_VALUE);
        readDeliveryLocationRequest.setDeliveryLocationId(createDeliveryLocationResponse.getDeliveryLocation()); 
        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(readDeliveryLocationRequest, ReadDeliveryLocationFunction.FUNCTION_NAME));
        ReadDeliveryLocationResponse readDeliveryLocationResponse  = readEncodedValue(responseEvent.getBody(), ReadDeliveryLocationResponse.class);
        assertNotNull(readDeliveryLocationResponse);
        assertEquals(200, readDeliveryLocationResponse.getStatusCode());
        assertTrue(readDeliveryLocationResponse.getFindings().size()==1);
        
        String dummyOtherValue = DUMMY_VALUE + "_OTHER";
        readDeliveryLocationRequest.setRequestId(DUMMY_VALUE);
        readDeliveryLocationRequest.setDeliveryLocationId(dummyOtherValue);

        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(readDeliveryLocationRequest, ReadDeliveryLocationFunction.FUNCTION_NAME));
        readDeliveryLocationResponse  = readEncodedValue(responseEvent.getBody(), ReadDeliveryLocationResponse.class);
        
        assertEquals(200, readDeliveryLocationResponse.getStatusCode());
        assertTrue(readDeliveryLocationResponse.getFindings().size()==0);
        
        readDeliveryLocationRequest = new ReadDeliveryLocationRequest();
        readDeliveryLocationRequest.setRequestId(DUMMY_VALUE);
        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(readDeliveryLocationRequest, ReadDeliveryLocationFunction.FUNCTION_NAME));
        readDeliveryLocationResponse  = readEncodedValue(responseEvent.getBody(), ReadDeliveryLocationResponse.class);
        
        assertEquals(200, readDeliveryLocationResponse.getStatusCode());
        assertTrue(readDeliveryLocationResponse.getFindings().size()>0);        
        
    	SaveDeliveryLocationRequest updateRequest = new SaveDeliveryLocationRequest();
    	updateRequest.setRequestId(DUMMY_VALUE);
    	updateRequest.setDeliveryLocationId(createDeliveryLocationResponse.getDeliveryLocation());
    	updateRequest.setBusinessName(DUMMY_VALUE);
    	updateRequest.setCountry(DUMMY_VALUE);
    	updateRequest.setDetails(DUMMY_VALUE);
    	updateRequest.setEmail(DUMMY_EMAIL);
    	updateRequest.setLocation(DUMMY_VALUE);
    	updateRequest.setNumber(DUMMY_VALUE);
    	updateRequest.setPostalCode(DUMMY_VALUE);
    	updateRequest.setRegion(DUMMY_VALUE);
    	updateRequest.setStreet(DUMMY_VALUE);
    	
        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(updateRequest, SaveDeliveryLocationFunction.FUNCTION_NAME));
        SaveDeliveryLocationResponse updateDeliveryLocationResponse  = readEncodedValue(responseEvent.getBody(), SaveDeliveryLocationResponse.class);
        
        assertEquals(200, updateDeliveryLocationResponse.getStatusCode());

        DeleteDeliveryLocationRequest deleteDeliveryLocationRequest = new DeleteDeliveryLocationRequest();
        deleteDeliveryLocationRequest.setRequestId(DUMMY_VALUE);
        deleteDeliveryLocationRequest.setDeliveryLocationId(createDeliveryLocationResponse.getDeliveryLocation());
        
        responseEvent = (APIGatewayProxyResponseEvent) lambda.execute(makeRequestEvent(deleteDeliveryLocationRequest, DeleteDeliveryLocationFunction.FUNCTION_NAME));
        assertEquals(200, responseEvent.getStatusCode());
        
        
    }
}
