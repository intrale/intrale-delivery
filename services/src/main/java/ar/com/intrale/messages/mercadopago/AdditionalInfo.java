package ar.com.intrale.messages.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionalInfo {

    @JsonProperty("authentication_code")
    private String authenticationCode;
    @JsonProperty("available_balance")
    private String availableBalance;
    @JsonProperty("nsu_processadora")
    private String nsuProcessadora;

    public void setAuthenticationCode(String authenticationCode) {
         this.authenticationCode = authenticationCode;
     }
     public String getAuthenticationCode() {
         return authenticationCode;
     }

    public void setAvailableBalance(String availableBalance) {
         this.availableBalance = availableBalance;
     }
     public String getAvailableBalance() {
         return availableBalance;
     }

    public void setNsuProcessadora(String nsuProcessadora) {
         this.nsuProcessadora = nsuProcessadora;
     }
     public String getNsuProcessadora() {
         return nsuProcessadora;
     }

}