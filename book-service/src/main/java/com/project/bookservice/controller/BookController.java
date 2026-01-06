package com.project.bookservice.controller;

import com.project.bookservice.dto.BookDto;
import com.project.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book-info")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/book")
    public String getBook() {
        return "book";
    }

    @GetMapping("/books")
    public String getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/book")
    public String createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PostMapping("/books")
    public String createBooks() {
        return "post books";
    }
}
