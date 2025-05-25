package com.userservice.tata.User;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLLETABLE")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private long roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
}
