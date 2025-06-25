package fr.hb.mlang.business.entities;

import fr.hb.mlang.business.enums.ProjectStatus;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "available_budget")
    private Integer availableBudget;

    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "product_owner_id", nullable = false)
    private ProductOwner productOwner;

    @OneToMany(mappedBy = "project")
    private Set<JobApplication> jobApplications = new HashSet<>();

    public Project() {
    }
}
