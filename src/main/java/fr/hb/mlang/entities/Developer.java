package fr.hb.mlang.entities;

import java.util.ArrayList;
import java.util.List;

public class Developer extends User {

    private Long id;

    private String firstName;

    private String lastName;

    private String description;

    private List<Skill> skill = new ArrayList<>();

    private List<JobApplication> jobApplications = new ArrayList<>();
}
