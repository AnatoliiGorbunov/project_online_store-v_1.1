package ru.geekbrains.project_online_store.v_11.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "title")
    private String title;

    public Cart(Long product_id, String title) {
        this.product_id = product_id;
        this.title = title;
    }
}

   // cart (id bigserial, user_id bigint, user_id references users(id));