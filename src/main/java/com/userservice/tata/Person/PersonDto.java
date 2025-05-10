package com.userservice.tata.Person;


public class PersonDto {
    private String personPhoneNumber;
    private String personFamily;
    private String personName;
    private long personId;

    public PersonDto(String personPhoneNumber, String personFamily, String personName, long personId) {
        this.personPhoneNumber = personPhoneNumber;
        this.personFamily = personFamily;
        this.personName = personName;
        this.personId = personId;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonFamily() {
        return personFamily;
    }

    public void setPersonFamily(String personFamily) {
        this.personFamily = personFamily;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
