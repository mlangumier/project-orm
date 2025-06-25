package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_OWNER")
public class ProductOwner extends Profile {

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @OneToMany(mappedBy = "productOwner")
    private Set<Project> projects = new HashSet<>();

    @OneToOne(mappedBy = "productOwner")
    private User user;

}
