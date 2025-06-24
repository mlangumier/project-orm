package fr.hb.mlang.business.entities;

import fr.hb.mlang.business.enums.ApplicationStatus;

public class Application {

    private Long id;

    private String message;

    private ApplicationStatus status;

    private Project project;

    private Developer developer;

}
