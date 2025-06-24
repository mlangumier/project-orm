package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "THEME")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

//    private Set<Project> projects =  new HashSet<Project>(); // Many
}
