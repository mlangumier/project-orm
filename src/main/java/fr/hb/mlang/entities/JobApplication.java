package fr.hb.mlang.entities;

import fr.hb.mlang.enums.ApplicationStatus;

public class JobApplication {

    private Long id;

    private String message;

    private ApplicationStatus status;

    private Project project;

    private Developer developer;

}
