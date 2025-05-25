package com.userservice.tata.User;

import com.userservice.tata.Bases.BaseEntity;
import com.userservice.tata.Annotation.EntityField;
import jakarta.persistence.*;

@Entity
@Table(name = "USERTABLE")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "USER_NAME",nullable = false)
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToOne
    @JoinColumn(name = "JOIN_ROLE_ID")
    @EntityField()
    private RolesEntity rolesEntity;


}
