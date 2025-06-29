package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Developer;
import fr.hb.mlang.business.entities.JobApplication;
import fr.hb.mlang.business.entities.Project;
import fr.hb.mlang.business.entities.Theme;
import fr.hb.mlang.business.enums.ProjectStatus;
import fr.hb.mlang.business.repositories.interfaces.DeveloperRepository;
import fr.hb.mlang.business.utils.JpaFactory;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<Developer, Long>
        implements DeveloperRepository {

    public DeveloperRepositoryImpl() {
        super(Developer.class, "FROM Developer d LEFT JOIN FETCH d.skills");
    }

    @Override
    public List<Project> showAllProjects() {
        ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();

        return projectRepository.findAll();
    }

    @Override
    public List<Project> showAllProjectsFilteredByStatus(ProjectStatus status) {
        List<Project> projects = new ArrayList<>();
        EntityManager em = JpaFactory.getEntityManager();

        try (em) {
            projects = em.createQuery("FROM Project p WHERE p.status=:status", Project.class)
                    .setParameter("status", status)
                    .getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return projects;
    }

    @Override
    public List<Project> showAllProjectsWithTheme(Theme theme) {
        List<Project> projects = new ArrayList<>();
        EntityManager em = JpaFactory.getEntityManager();

        try (em) {
            projects = em.createQuery("FROM Project p WHERE p.theme=:theme", Project.class)
                    .setParameter("theme", theme)
                    .getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return projects;
    }

    @Override
    public List<Project> showAllProjectsWithDeliveryAfterDate(LocalDate deliveryDate) {
        List<Project> projects = new ArrayList<>();
        EntityManager em = JpaFactory.getEntityManager();

        try (em) {
            projects = em.createQuery("FROM Project p WHERE p.deliveryDate>=:deliveryDate", Project.class)
                    .setParameter("deliveryDate", deliveryDate)
                    .getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return projects;
    }

    @Override
    public List<Project> showAllProjectsWithBudgetAbove(Integer availableBudget) {
        List<Project> projects = new ArrayList<>();
        EntityManager em = JpaFactory.getEntityManager();

        try (em) {
            projects = em.createQuery("FROM Project p WHERE p.availableBudget>=:availableBudget", Project.class)
                    .setParameter("availableBudget", availableBudget)
                    .getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return projects;
    }

    @Override
    public boolean applyToProject(JobApplication jobApplication) {
        JobApplicationRepositoryImpl jobApplicationRepository = new JobApplicationRepositoryImpl();

        try {
            jobApplicationRepository.persist(jobApplication);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //TODO: Setup generic method for showAllProjects(filter)
//    private void queryProjectsByFilter(String qlString) {}
}
