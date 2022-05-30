package ru.geekbrains.project_online_store.v_11.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.project_online_store.v_11.data.Product;

public class ProductSpecification {

    public static Specification<Product> scoreGreaterOrElseThen(Integer cost) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost));
        //root - Product в данном случае (query, criteriaBuilder - нужны для того чтобы делать запрос)
        // в criteriaBuilder есть те еж методы что и в SQL (в данном случае он будет искать больший или эквивалентны чему то там)
        // в данном случае ищем по полю cost и передаем сюда сам score
    }
    public static Specification<Product> lessThanOrEqualTo(Integer cost) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost));
    }

    // select p From Product p where name like %bo%
    public static Specification<Product> nameLike(String nameTitle) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", nameTitle)));//%%  %  Экранируем %bo%(какое то значение)
    }

}
