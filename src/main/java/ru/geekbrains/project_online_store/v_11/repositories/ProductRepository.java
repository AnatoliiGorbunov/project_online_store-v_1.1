package ru.geekbrains.project_online_store.v_11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.project_online_store.v_11.data.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

        @Query("select p from Product p where p.cost between :min and :max")
        List<Product>findAllByCostBetween(Integer min, Integer max);

        boolean existsProductByTitle(String name);

        boolean existsProductById(Long id);
}
