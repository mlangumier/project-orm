package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.Theme;
import fr.hb.mlang.business.repositories.interfaces.ThemeRepository;

public class ThemeRepositoryImpl extends AbstractGenericCrudRepositoryImpl<Theme, Long> implements ThemeRepository {

    public ThemeRepositoryImpl() {
        super(Theme.class, "FROM Theme");
    }
}
