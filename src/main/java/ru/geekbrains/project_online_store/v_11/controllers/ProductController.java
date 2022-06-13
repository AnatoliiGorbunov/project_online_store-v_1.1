package ru.geekbrains.project_online_store.v_11.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.project_online_store.v_11.converters.ProductConverter;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.dto.ProductDto;
import ru.geekbrains.project_online_store.v_11.services.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping()
    public Page<ProductDto> getAllProduct(@RequestParam(name = "p", defaultValue = "1") Integer page,
                                       @RequestParam(name = "min_cost", required = false) Integer minCost,
                                       @RequestParam(name = "max_cost", required = false) Integer maxCost,
                                       @RequestParam(name = "title_part", required = false) String partTitle) {
        if (page < 1) {
            page = 1;
        }
        return productService.find(page, maxCost, minCost, partTitle).map(productConverter::entityToDto);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/filterBetweenCost")
    public List<Product> findProductByCostBetween(@RequestParam(name = "min") Integer min, @RequestParam(name = "max") Integer max) {
        return productService.findByCostBetween(min, max);
    }

    @DeleteMapping("/{id}")
    public void useDeleteMappingById(@PathVariable long id) {
        productService.deleteById(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @GetMapping("/find/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return productService.update(productDto);
    }

    // /api/v1/products/{id}/title CORRECT
    // /api/v1/products/title/{id} NOT CORRECT

    @PatchMapping("/{id}/title")
    public void patchTitle(@PathVariable Long id, @RequestBody ProductDto productDto){
        productService.updateTitle(id, productDto);
    }
}



