package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Skill;
import fr.hb.mlang.business.repositories.interfaces.SkillRepository;

public class SkillRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<Skill, Long> implements SkillRepository {

    public SkillRepositoryImpl() {
        super(Skill.class, "FROM Skill");
    }
}
