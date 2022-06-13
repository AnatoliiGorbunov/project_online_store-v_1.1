package ru.geekbrains.project_online_store.v_11.converters;

import ru.geekbrains.project_online_store.v_11.data.Cart;
import ru.geekbrains.project_online_store.v_11.dto.CartDto;

public class CartConverter {

    public Cart dtoToEntity(CartDto cartDto){
        return new Cart(cartDto.getProduct_id(), cartDto.getTitle());
    }
}
