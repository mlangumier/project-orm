package fr.hb.mlang.business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT_OWNER")
public class ProductOwner extends Role {

    @Column(name = "business_name", nullable = false)
    private String businessName;

//    private Set<Project> projects = new HashSet<>(); // Can have several
}
