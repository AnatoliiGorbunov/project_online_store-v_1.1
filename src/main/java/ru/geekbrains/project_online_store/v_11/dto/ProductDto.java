package ru.geekbrains.project_online_store.v_11.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.project_online_store.v_11.data.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String title;
    private Integer cost;

    public ProductDto(Product product) {//конструктор копирования
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}
