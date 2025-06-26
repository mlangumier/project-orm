package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_OWNER")
public class ProductOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "productOwner")
    private Set<Project> projects = new HashSet<>();

    /**
     * Default constructor
     */
    public ProductOwner() {
    }

    /**
     * Entity constructor
     *
     * @param businessName Official name of the business who owns the project
     */
    public ProductOwner(String businessName) {
        this.businessName = businessName;
    }

    /**
     * Entry constructor
     *
     * @param id           Database identifier
     * @param businessName Official name of the business who owns the project
     * @param user         The user this ProductOwner profile belongs to
     */
    public ProductOwner(Long id, String businessName, User user) {
        this.id = id;
        this.businessName = businessName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "ProductOwner{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", user=" + this.getUser() +
//                ", projects=" + projects +
                '}';
    }
}
