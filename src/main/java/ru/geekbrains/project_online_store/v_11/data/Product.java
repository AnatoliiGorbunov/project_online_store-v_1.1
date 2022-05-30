package ru.geekbrains.project_online_store.v_11.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "example")
    private Integer example;

    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product(String title, Integer cost, Integer example) {
        this.title = title;
        this.cost = cost;
        this.example = example;
    }
}
