package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEVELOPER")
public class Developer extends User {

    @Column(name = "first_name", nullable = false)
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
    private Set<JobApplication> jobApplications = new HashSet<>();

    public Developer() {
    }

    public Developer(String firstName, String lastName, String description, Set<Skill> skills, Set<JobApplication> jobApplications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.skills = skills;
        this.jobApplications = jobApplications;
    }

    public Developer(String username, String email, String password, String firstName, String lastName, String description, Set<Skill> skills, Set<JobApplication> jobApplications) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.skills = skills;
        this.jobApplications = jobApplications;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", skills=" + skills +
                ", jobApplications=" + jobApplications +
                '}';
    }
}
