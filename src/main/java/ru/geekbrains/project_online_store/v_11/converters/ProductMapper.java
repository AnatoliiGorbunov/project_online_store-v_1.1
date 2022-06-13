package ru.geekbrains.project_online_store.v_11.converters;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.dto.ProductDto;

public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);

    @InheritInverseConfiguration // указываем аннотацию что будем возвращать DTO, принимать Сущность;
    ProductDto fromProduct(Product product);
}
