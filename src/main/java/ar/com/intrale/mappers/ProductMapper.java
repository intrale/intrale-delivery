package ar.com.intrale.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ar.com.intrale.messages.PriceMessage;
import ar.com.intrale.messages.ProductMessage;
import ar.com.intrale.models.OrderProduct;
import ar.com.intrale.models.OrderProductPrice;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	OrderProduct requestToModel(ProductMessage request);
	//DeliveryLocationMessage modelToRequest(DeliveryLocation deliveryLocation);
	
	OrderProductPrice priceMessageToOrderProductPrice(PriceMessage priceMessage);
	
	
}
