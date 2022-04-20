package ar.com.intrale.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import ar.com.intrale.tools.JsonConverter;

public class OrderProductToJsonConverter extends JsonConverter<OrderProduct> implements DynamoDBTypeConverter<String, OrderProduct> {

}
