package com.userservice.tata.User;

import jakarta.persistence.*;

@Entity
@Table(name = "ENTITIESTABLE")
public class EntitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTITY_ID")
    private long roleId;
    @Column(name = "ENTITY_NAME")
    private String roleName;
}
