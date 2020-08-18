package com.geekbrains.book.store.repositories.specifications;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.utils.Genre;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecifications {

    public static Specification<Book> maxPrice(int maxPrice) {
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), maxPrice);
    }

    public static Specification<Book> minPrice(int minPrice) {
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), minPrice);
    }

    public static Specification<Book> publishYear(int publishYear) {
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("publishYear"), publishYear);
    }

    public static Specification<Book> title(String title) {
        return (Specification<Book>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }
}
