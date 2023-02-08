package com.bonyeon.jpa.data.repository.support;

import com.bonyeon.jpa.data.entity.Product;
import com.bonyeon.jpa.data.entity.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct qProduct = QProduct.product;

        return from(qProduct)
                .where(qProduct.name.eq(name))
                .select(qProduct)
                .fetch();
    }
}
