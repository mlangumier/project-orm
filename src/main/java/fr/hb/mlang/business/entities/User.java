package fr.hb.mlang.business.entities;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

public abstract class User {

    private Long id;

    private String username;

    private String email;

    private String hashedPassword;

    private Set<Role> roles = new HashSet<>(); // OneToMany
}
