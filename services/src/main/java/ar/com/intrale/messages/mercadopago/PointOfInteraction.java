package ar.com.intrale.messages.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PointOfInteraction {

    @JsonProperty("business_info")
    private BusinessInfo businessInfo;
    private String type;
    public void setBusinessInfo(BusinessInfo businessInfo) {
         this.businessInfo = businessInfo;
     }
     public BusinessInfo getBusinessInfo() {
         return businessInfo;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

}