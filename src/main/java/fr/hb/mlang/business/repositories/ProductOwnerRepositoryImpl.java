package fr.hb.mlang.business.repositories;

import fr.hb.mlang.business.entities.ProductOwner;

public class ProductOwnerRepositoryImpl extends AbstractGenericCrudRepositoryImpl<ProductOwner,Long> {

    public  ProductOwnerRepositoryImpl() {
        super(ProductOwner.class, "FROM ProductOwner");
    }
}
