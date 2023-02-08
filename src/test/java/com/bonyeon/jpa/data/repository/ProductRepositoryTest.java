package com.bonyeon.jpa.data.repository;

import com.bonyeon.jpa.data.entity.Product;
import com.bonyeon.jpa.data.entity.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest // @transactional 포함 테스트 종료 시 자동 롤백
class ProductRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void saveTest() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(2000);

        // when
        Product savedProduct = productRepository.save(product);

        // then
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getStock(), savedProduct.getStock());
    }

    @Test
    void getProduct() {
        // given
        Product product = new Product();
        product.setName("펜");
        product.setPrice(1000);
        product.setStock(2000);
        Product savedProduct = productRepository.save(product);

        // when
        Optional<Product> findProduct = productRepository.findById(savedProduct.getNumber());

        Assertions.assertNotNull(findProduct);
    }

    @Test
    void queryDslTest() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct product = QProduct.product;

        List<Product> productList = jpaQueryFactory.selectFrom(product)
                .where(product.name.eq("펜"))
                .orderBy(product.price.asc())
                .fetch();

        for (Product pro : productList) {
            System.out.println("------------------");
            System.out.println();
            System.out.println("Product Number : " + pro.getNumber());
            System.out.println("Product Name : " + pro.getName());
            System.out.println("Product Price : " + pro.getPrice());
            System.out.println("Product Stock : " + pro.getStock());
            System.out.println("------------------");
        }
    }

    @Test
    void queryDslTest3() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("------------------");
            System.out.println();
            System.out.println("Product Name : " + product);
            System.out.println("------------------");
        }

        List<Tuple> tupleList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList) {
            System.out.println("--------------------");
            System.out.println("Product Name : " + product.get(qProduct.name));
            System.out.println("");
            System.out.println("--------------------");
        }
    }

    @Test
    void queryDslTest4() {
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("------------------");
            System.out.println();
            System.out.println("Product Name : " + product);
            System.out.println("------------------");
        }
    }
}