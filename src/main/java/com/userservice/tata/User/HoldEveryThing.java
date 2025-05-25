package com.userservice.tata.User;

import jakarta.persistence.*;

@Entity
@Table(name = "HOLDEVERYTHINGTABLR")
public class HoldEveryThing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "ROLE_ID", nullable = false)
    @ManyToOne
    private RolesEntity rolesEntity;
    @JoinColumn(name = "ACTION_ID", nullable = false)
    @ManyToOne
    private ActionEntity actionEntity;
    @JoinColumn(name = "ENTITTY_ID", nullable = false)
    @ManyToOne
    private EntitiesEntity entitiesEntity;

}
