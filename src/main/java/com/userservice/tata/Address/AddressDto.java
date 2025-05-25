package com.userservice.tata.Address;


import com.userservice.tata.Annotation.DtoField;
import com.userservice.tata.Person.PersonEntity;

public class AddressDto {
    private String Address;
    private boolean AddressStatus;
    private long AddressId;
    @DtoField(entityField = "person.personName",entityClass = PersonEntity.class)
    private String JoinPerson;

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

    public long getAddressId() {
        return AddressId;
    }

    public void setAddressId(long addressId) {
        AddressId = addressId;
    }

    public String getJoinPerson() {
        return JoinPerson;
    }

    public void setJoinPerson(String joinPerson) {
        JoinPerson = joinPerson;
    }
}
