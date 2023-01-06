package ar.com.intrale.messages;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.micronaut.core.annotation.Introspected;

@Introspected
/*
 {
  "id": 12345,
  "live_mode": true,
  "type": "payment",
  "date_created": "2015-03-25T10:04:58.396-04:00",
  "application_id": 123123123,
  "user_id": 44444,
  "version": 1,
  "api_version": "v1",
  "action": "payment.created",
  "data": {
      "id": "999999999"
  }
 */
public class MercadoPagoNotificationActionRequest extends MercadoPagoNotificationRequest {
	
	private Boolean liveMode;
	private String type;
	private Date created;
	private String applicationID;
	private String userId;
	private String version;
	private String apiVersion;
	private String action;
	private MercadoPagoWHData data;

	@JsonProperty("id")
	@Override
	public @NotBlank String getRequestId() {
		return super.getRequestId();
	}
	
	public Boolean getLiveMode() {
		return liveMode;
	}

	public void setLiveMode(Boolean liveMode) {
		this.liveMode = liveMode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public MercadoPagoWHData getData() {
		return data;
	}

	public void setData(MercadoPagoWHData data) {
		this.data = data;
	}

}
