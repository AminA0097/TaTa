package com.userservice.tata.Person;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONTABLE")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private long personId;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "PERSON_FAMILY")
    private String personFamily;

    @Column(name = "PERSON_PHONE_NUMBER")
    private String personPhoneNumber;


    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
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
