package ar.com.intrale;

import javax.inject.Inject;

import org.mapstruct.factory.Mappers;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import ar.com.intrale.client.ProductClient;
import ar.com.intrale.mappers.OrderMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;

@Factory
@Requires(property = IntraleFactory.FACTORY, value = IntraleFactory.TRUE, defaultValue = IntraleFactory.TRUE)
public class DeliveryFactory extends IntraleFactory<AmazonDynamoDB>{
	
	@Inject
	private ProductClient productClient;
	
	@Inject
	private ApplicationContext applicationContext;

	@Bean @Requires(property = IntraleFactory.PROVIDER, value = IntraleFactory.TRUE, defaultValue = IntraleFactory.TRUE)
	@Override
	public AmazonDynamoDB provider() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(config.getDatabase().getAccess(), config.getDatabase().getSecret());
    	
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
          .withCredentials(new AWSStaticCredentialsProvider(credentials))
          .withRegion(config.getAws().getRegion())
          .build();
         
        return amazonDynamoDB;
	}
	
	@Bean 
	public OrderMapper orderMapper() {
		OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
		orderMapper.setProductClient(productClient);
		orderMapper.setProvider(applicationContext.getBean(AmazonDynamoDB.class));
		return orderMapper;
	}

}
