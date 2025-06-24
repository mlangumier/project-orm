package fr.hb.mlang.business.entities;

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
    private Date deliveryDate; // optional

    @Column(name = "available_budget")
    private Integer availableBudget;

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @OneToMany(mappedBy = "project")
    private Set<Application> applications = new HashSet<>();
}
