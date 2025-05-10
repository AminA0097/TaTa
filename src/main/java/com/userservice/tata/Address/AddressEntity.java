package com.userservice.tata.Address;

import com.userservice.tata.More.EntityField;
import com.userservice.tata.More.IsBoolean;
import com.userservice.tata.More.convertToDatabaseColumn;
import com.userservice.tata.Person.PersonEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESSTABLE")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private long AddressID;

    @Convert(converter = convertToDatabaseColumn.class)
    @Column(name = "ADDRESS_STATUS")
    @IsBoolean()
    private boolean AddressStatus;

    @Column(name = "ADDRESS",length = 255)
    private String Address;

    @ManyToOne
    @JoinColumn(name = "JOIN_PERSON_ID")
    @EntityField()
    private PersonEntity JoinPerson;

    public long getAddressID() {
        return AddressID;
    }

    public void setAddressID(long addressID) {
        AddressID = addressID;
    }

    public boolean isAddressStatus() {
        return AddressStatus;
    }

    public void setAddressStatus(boolean addressStatus) {
        AddressStatus = addressStatus;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public PersonEntity getJoinPerson() {
        return JoinPerson;
    }

    public void setJoinPerson(PersonEntity joinPerson) {
        JoinPerson = joinPerson;
    }
}
