package com.userservice.tata.Address;


import com.userservice.tata.Annotation.DtoField;
import com.userservice.tata.Person.PersonEntity;

public class AddressDto {
    private String Address;
    private String AddressStatus;
    private long AddressId;
    @DtoField(entityField = "person.personName",entityClass = PersonEntity.class)
    private String personName;

    public AddressDto(AddressEntity addressEntity) {
        this.AddressId = addressEntity.getAddressID() ;
        this.Address = addressEntity.getAddress() == null ? "No Address!" :addressEntity.getAddress() ;
        this.AddressStatus = addressEntity.isAddressStatus() == true ? "Active" : "NotActive";
        this.personName = addressEntity.getJoinPerson().getPersonName() == null ? "No Named!" :addressEntity.getJoinPerson().getPersonName() ;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddressStatus() {
        return AddressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        AddressStatus = addressStatus;
    }

    public long getAddressId() {
        return AddressId;
    }

    public void setAddressId(long addressId) {
        AddressId = addressId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
