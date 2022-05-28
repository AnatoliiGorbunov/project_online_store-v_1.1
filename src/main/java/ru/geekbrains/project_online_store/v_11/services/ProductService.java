package ru.geekbrains.project_online_store.v_11.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.project_online_store.v_11.data.Product;
import ru.geekbrains.project_online_store.v_11.repositories.ProductRepository;
import ru.geekbrains.project_online_store.v_11.specification.ProductSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
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

}

//    public void addProduct(Product product) {
//        if (productRepository.existsProductByName(product.getTitle())) {
//            throw new EntityExistsException("This product is already");
//        } else {
//            productRepository.save(product);
//        }
//    }





