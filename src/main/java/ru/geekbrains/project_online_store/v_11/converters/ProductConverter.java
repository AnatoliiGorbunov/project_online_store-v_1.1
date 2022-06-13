package ru.geekbrains.project_online_store.v_11.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.dto.ProductDto;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }

    public ProductDto hardEntityToDto(Product product){
        return ProductDto.builder()//билдер позволяет создавать сущности с любым количеством полей
                .cost(product.getCost())
                .title(product.getTitle())//можем прописать тернарный оператор
                .build();
    }
}
