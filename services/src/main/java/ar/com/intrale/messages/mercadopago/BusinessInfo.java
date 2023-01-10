package ar.com.intrale.messages.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusinessInfo {

    @JsonProperty("sub_unit")
    private String subUnit;
    private String unit;
    
    public void setSubUnit(String subUnit) {
         this.subUnit = subUnit;
     }
     public String getSubUnit() {
         return subUnit;
     }

    public void setUnit(String unit) {
         this.unit = unit;
     }
     public String getUnit() {
         return unit;
     }

}