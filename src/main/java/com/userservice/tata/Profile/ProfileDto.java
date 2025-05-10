package com.userservice.tata.Profile;


import com.userservice.tata.Address.AddressEntity;
import com.userservice.tata.Person.PersonEntity;

public class ProfileDto {
    private String personName;
    private String personFamily;
    private String personPhoneNumber;
    private String address;
    public ProfileDto(PersonEntity personEntity, AddressEntity addressEntity) {
        this.personName = personEntity.getPersonName();
        this.personFamily = personEntity.getPersonFamily();
        this.personPhoneNumber = personEntity.getPersonPhoneNumber();
        this.address = addressEntity.getAddress();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonFamily() {
        return personFamily;
    }

    public void setPersonFamily(String personFamily) {
        this.personFamily = personFamily;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }
}
