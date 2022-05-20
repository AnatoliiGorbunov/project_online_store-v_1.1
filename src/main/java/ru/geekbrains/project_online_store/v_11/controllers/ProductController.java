package ru.geekbrains.project_online_store.v_11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
      return productService.getAllProduct();
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

}



//    получение товара по id [ GET .../app/products/{id} ]
//    получение всех товаров [ GET .../app/products ]
//    создание нового товара [ POST .../app/products ]
//    удаление товара по id.[ GET .../app/products/delete/{id} ]