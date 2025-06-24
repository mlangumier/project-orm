package fr.hb.mlang.business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEVELOPER")
public class Developer extends Role {

    @Column(name = "first_name",  nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "description")
    private String description;

//    private Set<Skill> skill = new HashSet<>(); // ManyToMany

//    private Set<Application> applications = new HashSet<>(); // ManyToMany
}
