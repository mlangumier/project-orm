package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_OWNER")
public class ProductOwner extends User {

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @OneToMany(mappedBy = "productOwner")
    private Set<Project> projects = new HashSet<>();

    public ProductOwner() {
    }

    public ProductOwner(String businessName, Set<Project> projects) {
        this.businessName = businessName;
        this.projects = projects;
    }

    public ProductOwner(String username, String email, String password, String businessName, Set<Project> projects) {
        super(username, email, password);
        this.businessName = businessName;
        this.projects = projects;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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
                "businessName='" + businessName + '\'' +
                ", projects=" + projects +
                '}';
    }
}
