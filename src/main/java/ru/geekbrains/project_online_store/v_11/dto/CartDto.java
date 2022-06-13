package ru.geekbrains.project_online_store.v_11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long id;
    private Long product_id;
    private String title;

    public CartDto(Long product_id, String title) {
        this.product_id = product_id;
        this.title = title;
    }
}
