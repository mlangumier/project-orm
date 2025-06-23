package fr.hb.mlang.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private Long id;

    private String title;

    private String description;

    private Date deliveryDate; // optional

    private Integer availableBudget;

    private Theme theme; // Only 1

    private List<JobApplication> jobApplications = new ArrayList<>(); // Can have many
}
