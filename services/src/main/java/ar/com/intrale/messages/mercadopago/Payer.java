package ar.com.intrale.messages.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payer {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private Identification identification;
    private Phone phone;
    private String type;
    @JsonProperty("entity_type")
    private String entityType;
    private String id;
    public void setFirstName(String firstName) {
         this.firstName = firstName;
     }
     public String getFirstName() {
         return firstName;
     }

    public void setLastName(String lastName) {
         this.lastName = lastName;
     }
     public String getLastName() {
         return lastName;
     }

    public void setEmail(String email) {
         this.email = email;
     }
     public String getEmail() {
         return email;
     }

    public void setIdentification(Identification identification) {
         this.identification = identification;
     }
     public Identification getIdentification() {
         return identification;
     }

    public void setPhone(Phone phone) {
         this.phone = phone;
     }
     public Phone getPhone() {
         return phone;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setEntityType(String entityType) {
         this.entityType = entityType;
     }
     public String getEntityType() {
         return entityType;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

}