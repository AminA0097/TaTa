package com.userservice.tata.User;

import jakarta.persistence.*;

@Entity
@Table(name = "ACTIONTABALE")
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Action_ID")
    private long roleId;
    @Column(name = "Action_NAME")
    private String roleName;
}
