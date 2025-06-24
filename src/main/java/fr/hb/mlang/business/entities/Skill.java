package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SKILL")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
