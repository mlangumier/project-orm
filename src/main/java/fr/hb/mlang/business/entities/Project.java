package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "PROJECT", schema = "PROJECT_ORM_DB")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Date deliveryDate; // optional

    private Integer availableBudget;

    private Theme theme; // OneToOne

    private Set<Application> applications = new HashSet<>(); // ManyToMany
}
