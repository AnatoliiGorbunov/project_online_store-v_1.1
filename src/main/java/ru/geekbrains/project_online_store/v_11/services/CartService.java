package ru.geekbrains.project_online_store.v_11.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.project_online_store.v_11.converters.ProductConverter;
import ru.geekbrains.project_online_store.v_11.data.Cart;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.dto.ProductDto;
import ru.geekbrains.project_online_store.v_11.repositories.CartRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {


    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ProductConverter productConverter;


    public void deleteById(Long productId) {
        cartRepository.deleteById(productId);
    }

    public Optional<Cart> findById(Long productId) {
        return cartRepository.findById(productId);
    }
}
