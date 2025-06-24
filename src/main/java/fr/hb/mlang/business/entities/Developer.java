package fr.hb.mlang.business.entities;

import java.util.HashSet;
import java.util.Set;

public class Developer extends Role {

    private String firstName;

    private String lastName;

    private String description;

//    private Set<Skill> skill = new HashSet<>(); // ManyToMany

    private Set<Application> applications = new HashSet<>(); // ManyToMany
}
