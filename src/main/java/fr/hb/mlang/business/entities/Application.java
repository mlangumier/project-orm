package fr.hb.mlang.business.entities;

import fr.hb.mlang.business.enums.ApplicationStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "status", nullable = false)
    private ApplicationStatus status;

//    private Project project;

//    private Developer developer;

}
