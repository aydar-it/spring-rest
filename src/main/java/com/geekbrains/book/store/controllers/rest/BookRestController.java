package com.geekbrains.book.store.controllers.rest;

import com.geekbrains.book.store.entities.Book;
import com.geekbrains.book.store.repositories.BookRepository;
import com.geekbrains.book.store.services.BookService;
import com.geekbrains.book.store.utils.BookFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/books")
public class BookRestController {
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/filter")
    public Page<Book> getFilterBooks(
                           @RequestParam(name = "p", defaultValue = "1") Integer pageIndex,
                           @RequestParam Map<String, String> params
    ) {
        BookFilter bf = new BookFilter(params);
        return bookService.findAll(bf.getSpec(), pageIndex - 1, 4);
    }
}
