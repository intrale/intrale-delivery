package ar.com.intrale.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ar.com.intrale.messages.DeliveryLocationMessage;
import ar.com.intrale.messages.SaveDeliveryLocationRequest;
import ar.com.intrale.models.DeliveryLocation;

@Mapper
public interface DeliveryLocationMapper {

	DeliveryLocationMapper INSTANCE = Mappers.getMapper(DeliveryLocationMapper.class);
	
	DeliveryLocation requestToModel(SaveDeliveryLocationRequest request);
	DeliveryLocationMessage modelToRequest(DeliveryLocation deliveryLocation);
	
}
