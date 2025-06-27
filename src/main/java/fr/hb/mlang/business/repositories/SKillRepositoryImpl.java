package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Skill;
import fr.hb.mlang.business.repositories.interfaces.SkillRepository;

public class SKillRepositoryImpl extends AbstractGenericCrudRepositoryImpl<Skill, Long> implements SkillRepository {

    public SKillRepositoryImpl() {
        super(Skill.class, "FROM Skill");
    }
}
