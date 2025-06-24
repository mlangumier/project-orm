package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Role {
    //INFO: check this to test & see how inheritance work: https://www.baeldung.com/hibernate-inheritance

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
