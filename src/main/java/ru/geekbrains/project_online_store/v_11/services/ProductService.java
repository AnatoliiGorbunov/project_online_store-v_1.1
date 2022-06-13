package ru.geekbrains.project_online_store.v_11.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.project_online_store.v_11.converters.ProductConverter;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.dto.ProductDto;
import ru.geekbrains.project_online_store.v_11.exceptions.ValidateException;
import ru.geekbrains.project_online_store.v_11.repositories.ProductRepository;
import ru.geekbrains.project_online_store.v_11.specification.ProductSpecification;
import ru.geekbrains.project_online_store.v_11.validators.ProductValidator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

//    public Optional<Product> findById(Long id) {
//        return productRepository.findById(id);
//    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(product -> productConverter.entityToDto(product)).orElseThrow();
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public Page<Product> find(Integer p, Integer maxCost, Integer minCost, String partTitle) {
        Specification<Product> spec = Specification.where(null);//Спецификация пустая в данный момент
        //select p from Product p where true
        if (minCost != null) {
            spec = spec.and(ProductSpecification.scoreGreaterOrElseThen(minCost));
        }
        //select p from Product p where true and cost > ?
        if (maxCost != null) {
            spec = spec.and(ProductSpecification.lessThanOrEqualTo(maxCost));
        }
        //select p from Product p where true and cost > ? AND cost < ?
        if (partTitle != null) {
            spec = spec.and(ProductSpecification.nameLike(partTitle));
        }
        //select p from Product p where true and cost > ? AND cost < ? AND like &title&

        return productRepository.findAll(spec, PageRequest.of(p - 1, 5));
    }

    public ProductDto addProduct(ProductDto product) {
        productValidator.validate(product);
        productRepository.save(productConverter.dtoToEntity(product));
        return product;
    }

    @Transactional
    public ProductDto update(ProductDto productDto) {
        if(!productRepository.existsProductById(productDto.getId())){
            throw new ValidateException(List.of("Продукта с таким id не существует"));
        }
        Product product = productRepository.getById(productDto.getId());
        product.setCost(productDto.getCost());
        product.setTitle(product.getTitle());
        return productDto;
    }

    @Transactional
    public void updateTitle(Long id, ProductDto productDto) {
        Product product = productRepository.getById(productDto.getId());
        product.setTitle(productDto.getTitle());
    }
}



