package ru.geekbrains.project_online_store.v_11.validators;

import com.sun.jdi.connect.VMStartException;
import org.springframework.stereotype.Component;
import ru.geekbrains.project_online_store.v_11.dto.ProductDto;
import ru.geekbrains.project_online_store.v_11.exceptions.ValidateException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    List<String> errors = new ArrayList<>();

    public void validate(ProductDto productDto) {
        if (productDto.getCost() < 1) {
            errors.add("Цена товара не может быть меньше 1");
        }

        if (productDto.getTitle().isBlank()) {
            errors.add("Название не может быть пустым");
        }

        if(!errors.isEmpty()){
            throw new ValidateException(errors);
        }
    }
}
