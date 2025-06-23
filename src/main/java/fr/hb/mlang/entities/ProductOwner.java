package fr.hb.mlang.entities;

import java.util.ArrayList;
import java.util.List;

public class ProductOwner extends User {

    private String businessName;

    private List<Project> projects = new ArrayList<>(); // Can have several
}
