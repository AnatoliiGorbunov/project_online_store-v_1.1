package ru.geekbrains.project_online_store.v_11.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.project_online_store.v_11.converters.CartConverter;
import ru.geekbrains.project_online_store.v_11.data.Cart;
import ru.geekbrains.project_online_store.v_11.dto.CartDto;
import ru.geekbrains.project_online_store.v_11.exceptions.ResourceNotFoundException;
import ru.geekbrains.project_online_store.v_11.services.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long productId) {
        cartService.deleteById(productId);
    }

    @GetMapping("/find/{id}")
    public CartDto findProductById(@PathVariable Long productId) {
        Cart cart = cartService.findById(productId).orElseThrow();
        return new CartDto(cart.getId(), cart.getProduct_id(), cart.getTitle());
    }
}

