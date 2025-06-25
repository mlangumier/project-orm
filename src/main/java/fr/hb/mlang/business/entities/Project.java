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

    @ManyToOne
    @JoinColumn(name = "product_owner_id", nullable = false)
    private ProductOwner productOwner;

    @OneToMany(mappedBy = "project")
    private Set<Application> applications = new HashSet<>();

    public Project() {
    }

    public Project(String title, String description, Date deliveryDate, Integer availableBudget, Theme theme, ProductOwner productOwner, Set<Application> applications) {
        this.title = title;
        this.description = description;
        this.deliveryDate = deliveryDate;
        this.availableBudget = availableBudget;
        this.theme = theme;
        this.productOwner = productOwner;
        this.applications = applications;
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

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", availableBudget=" + availableBudget +
                ", theme=" + theme +
                ", productOwner=" + productOwner +
                ", applications=" + applications +
                '}';
    }
}
