package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.ProductOwner;
import fr.hb.mlang.business.repositories.interfaces.ProductOwnerRepository;

public class ProductOwnerRepositoryImpl
        extends AbstractGenericCrudRepositoryImpl<ProductOwner, Long>
        implements ProductOwnerRepository {

    public ProductOwnerRepositoryImpl() {
        super(ProductOwner.class, "FROM ProductOwner");
    }
}
