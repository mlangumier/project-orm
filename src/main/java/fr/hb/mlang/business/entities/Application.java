package fr.hb.mlang.business.entities;

import fr.hb.mlang.business.enums.ApplicationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "APPLICATION")
public class Application {

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

    public Application() {
    }

    public Application(String message, LocalDateTime appliedAt, ApplicationStatus status, Project project, Developer developer) {
        this.message = message;
        this.appliedAt = appliedAt;
        this.status = status;
        this.project = project;
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", appliedAt=" + appliedAt +
                ", status=" + status +
                ", project=" + project +
                ", developer=" + developer +
                '}';
    }
}
