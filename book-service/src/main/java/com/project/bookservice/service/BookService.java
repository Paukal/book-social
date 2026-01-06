package com.project.bookservice.service;

import com.project.bookservice.dto.BookDto;
import com.project.bookservice.mapper.BookMapper;
import com.project.bookservice.model.Book;
import com.project.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper; // Injected by Spring

    public String getBooks() {
        return bookRepository.findAll().toString();
    }

    public String createBook(BookDto bookDto) {
        bookRepository.save(getBookEntity(bookDto));
        return "book created";
    }

    public BookDto getBookDto(Book book) {
        return bookMapper.bookToBookDto(book);
    }

    public Book getBookEntity(BookDto bookDto) {
        return bookMapper.bookDtoToBook(bookDto);
    }
}
