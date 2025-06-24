package fr.hb.mlang.business.entities;

import java.util.ArrayList;
import java.util.List;

public class ProductOwner extends Role {

    private String businessName;

    private List<Project> projects = new ArrayList<>(); // Can have several
}
