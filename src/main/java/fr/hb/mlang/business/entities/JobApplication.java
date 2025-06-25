package fr.hb.mlang.business.entities;

import fr.hb.mlang.business.enums.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "APPLICATION")
public class JobApplication {

    @Id
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "applied_at", nullable = false)
    private LocalDateTime appliedAt;

    @Column(name = "status", nullable = false)
    private ApplicationStatus status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    public JobApplication() {
    }
}
