package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@Entity(name = "ROLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role_type",
discriminatorType = DiscriminatorType.INTEGER)
public abstract class Role {
    //TODO: check this to test & see how inheritance work: https://www.baeldung.com/hibernate-inheritance
    // Right now: ROLE table exists, contains attributes from PRODUCT_OWNER and DEVELOPER
    // -> Causes issues for relational mapping regarding PRODUCT_OWNER and DEVELOPER

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
