package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("2")
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

    @OneToMany(mappedBy = "developer")
    private Set<Application> applications = new HashSet<>();

    public Developer() {
    }

    public Developer(String description, Set<Skill> skills, Set<Application> applications) {
        this.description = description;
        this.skills = skills;
        this.applications = applications;
    }

    public Developer(String firstName, String lastName, User user, String description, Set<Skill> skills, Set<Application> applications) {
        super(firstName, lastName, user);
        this.description = description;
        this.skills = skills;
        this.applications = applications;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "description='" + description + '\'' +
                ", skills=" + skills +
                ", applications=" + applications +
                '}';
    }
}
