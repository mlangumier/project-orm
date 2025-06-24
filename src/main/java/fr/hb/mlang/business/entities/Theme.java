package fr.hb.mlang.business.entities;

import java.util.HashSet;
import java.util.Set;

public class Theme {

    private Long id;

    private String name;

    private String description;

    private Set<Project> projects =  new HashSet<Project>(); // Many
}
