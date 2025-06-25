package fr.hb.mlang.business.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_owner_id", referencedColumnName = "id")
    private ProductOwner productOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;

}
