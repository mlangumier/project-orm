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
    private List<JobApplication> jobApplications = new ArrayList<>();

    public Project() {
    }

    public Project(String title, String description, Theme theme, ProductOwner productOwner) {
        this.title = title;
        this.description = description;
        this.status = ProjectStatus.PLANNING;
        this.theme = theme;
        this.productOwner = productOwner;
    }

    public Project(Long id, Date deliveryDate, Integer availableBudget, List<JobApplication> jobApplications) {
        this();
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.availableBudget = availableBudget;
        this.jobApplications = jobApplications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getAvailableBudget() {
        return availableBudget;
    }

    public void setAvailableBudget(Integer availableBudget) {
        this.availableBudget = availableBudget;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", availableBudget=" + availableBudget +
                ", status=" + status +
                ", theme=" + theme +
                '}';
    }
}
