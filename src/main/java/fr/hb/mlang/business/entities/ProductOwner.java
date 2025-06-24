package fr.hb.mlang.business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class ProductOwner extends Role {

    @Column(name = "business_name", nullable = false)
    private String businessName;

//    private Set<Project> projects = new HashSet<>(); // Can have several
}
