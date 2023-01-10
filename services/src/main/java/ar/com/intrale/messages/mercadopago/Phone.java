package ar.com.intrale.messages.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phone {

    @JsonProperty("area_code")
    private String areaCode;
    private String number;
    private String extension;
    public void setAreaCode(String areaCode) {
         this.areaCode = areaCode;
     }
     public String getAreaCode() {
         return areaCode;
     }

    public void setNumber(String number) {
         this.number = number;
     }
     public String getNumber() {
         return number;
     }

    public void setExtension(String extension) {
         this.extension = extension;
     }
     public String getExtension() {
         return extension;
     }

}