package ru.geekbrains.project_online_store.v_11.controllers;


import org.springframework.data.domain.Page;
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

    @GetMapping("/allProducts")
    public List<Product> getAllStudents() {
        return productService.getAllProduct();
    }

    @GetMapping("/products")
    public Page<Product> getAllProduct(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                       @RequestParam(name = "min_cost", required = false) Integer minCost,
                                       @RequestParam(name = "max_cost", required = false) Integer maxCost,
                                       @RequestParam(name = "title_part", required = false) String partTitle) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(page, maxCost, minCost, partTitle);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/filterBetweenCost")
    public List<Product> findProductByCostBetween(@RequestParam(name = "min") Integer min, @RequestParam(name = "max") Integer max) {
        return productService.findByCostBetween(min, max);
    }
}

//    @GetMapping("/products/{id}")
//    public Product findById(@PathVariable Long id) {
//        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " not found"));
//    }
//
//
//    @PostMapping("/products")
//    public void addProduct(@RequestBody Product product) {
//        productService.addProduct(product);
//    }




