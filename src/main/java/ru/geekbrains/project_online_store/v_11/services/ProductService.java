package ru.geekbrains.project_online_store.v_11.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public void addProduct(Product product){
        productRepository.saveAndFlush(product);
    }
}
