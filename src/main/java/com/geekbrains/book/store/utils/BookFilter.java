package com.geekbrains.book.store.utils;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.repositories.specifications.BookSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class BookFilter {
    private Specification<Book> spec;

    public BookFilter(Map<String, String> params) {
        spec = Specification.where(null);
        if (params.containsKey("maxPrice") && params.get("maxPrice").matches("\\d+")) {
            spec = spec.and(BookSpecifications.maxPrice(Integer.parseInt(params.get("maxPrice"))));
        }
        if (params.containsKey("minPrice") && params.get("minPrice").matches("\\d+")) {
            spec = spec.and(BookSpecifications.minPrice(Integer.parseInt(params.get("minPrice"))));
        }
        if (params.get("publishYear") != null && params.get("publishYear").matches("\\d+")) {
            spec = spec.and(BookSpecifications.publishYear(Integer.parseInt(params.get("publishYear"))));
        }
        if (params.get("title") != null && !params.get("title").equals("")) {
            spec = spec.and(BookSpecifications.title(params.get("title")));
        }
    }
}
