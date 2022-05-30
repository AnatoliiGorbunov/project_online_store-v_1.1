package ru.geekbrains.project_online_store.v_11.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.project_online_store.v_11.data.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private String title;
    private Integer cost;

    public ProductDto(Product product) {//конструктор копирования
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}