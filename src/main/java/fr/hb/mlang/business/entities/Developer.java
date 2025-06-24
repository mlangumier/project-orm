package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("2")
public class Developer extends Role {

    @Column(name = "first_name",  nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "DEVELOPER_SKILL",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "developer")
    private Set<Application> applications = new HashSet<>();
}
