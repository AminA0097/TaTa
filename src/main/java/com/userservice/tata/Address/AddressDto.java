package com.userservice.tata.Address;


import com.userservice.tata.More.DtoField;
import com.userservice.tata.Person.PersonDto;
import com.userservice.tata.Person.PersonEntity;

public class AddressDto {
    private String Address;
    private boolean AddressStatus;
    private long AddressID;
    @DtoField(entityField = "person.personId",entityClass = PersonEntity.class)
    private long personId;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isAddressStatus() {
        return AddressStatus;
    }

    public void setAddressStatus(boolean addressStatus) {
        AddressStatus = addressStatus;
    }

    public long getAddressID() {
        return AddressID;
    }

    public void setAddressID(long addressID) {
        AddressID = addressID;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
