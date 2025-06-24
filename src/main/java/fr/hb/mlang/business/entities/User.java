package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

//    private Set<Role> roles = new HashSet<>(); // OneToMany
}
