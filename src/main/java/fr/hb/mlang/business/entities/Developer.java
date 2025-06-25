package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEVELOPER")
public class Developer extends Profile {

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "DEVELOPER_SKILL",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @OneToOne(mappedBy = "developer")
    private User user;

    @OneToMany(mappedBy = "developer")
    private Set<Application> applications = new HashSet<>();
}
