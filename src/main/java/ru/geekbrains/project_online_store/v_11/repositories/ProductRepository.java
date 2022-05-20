package ru.geekbrains.project_online_store.v_11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.project_online_store.v_11.data.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
