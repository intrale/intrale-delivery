package ar.com.intrale.messages.mercadopago;

public class PaymentMethod {

    private String id;
    private String type;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

}