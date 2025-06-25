package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",  nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

}
