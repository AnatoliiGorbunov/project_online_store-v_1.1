package ru.geekbrains.project_online_store.v_11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.project_online_store.v_11.data.Cart;

import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("delete from Cart c where c.product_id = ?1")
    void deleteById(Long id);

    @Query("select c from Cart c where c.product_id = ?1")
    Optional<Cart> findById(Long id);


}
