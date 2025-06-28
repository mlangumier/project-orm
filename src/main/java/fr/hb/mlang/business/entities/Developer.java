package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEVELOPER")
public class Developer {

    @Id
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "description")
    private String description;

    @OneToOne
    @MapsId
    private User user;

    @ManyToMany
    @JoinTable(
            name = "DEVELOPER_SKILL",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "developer")
    private List<JobApplication> jobApplications = new ArrayList<>();

    /**
     * Default constructor
     */
    public Developer() {
    }

    /**
     * Entity constructor
     *
     * @param firstName   First name of the user
     * @param lastName    Last name of the user
     * @param description Description of the user's skills and experience
     */
    public Developer(User user, String firstName, String lastName, String description) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public Developer(String firstName, String lastName, String description, User user, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.user = user;
        this.skills = skills;
    }

    /**
     * Entry constructor
     *
     * @param id          Database identifier
     * @param firstName   First name of the user
     * @param lastName    Last name of the user
     * @param description Description of the user's skills and experience
     * @param user        Entity User who owns this Developer entity
     */
    public Developer(Long id, String firstName, String lastName, String description, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
//                ", skills=" + skills +
//                ", jobApplications=" + jobApplications +
                '}';
    }
}
