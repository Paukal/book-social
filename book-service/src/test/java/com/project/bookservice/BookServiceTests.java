package com.project.bookservice;

import com.project.bookservice.dto.BookDto;
import com.project.bookservice.mapper.BookMapper;
import com.project.bookservice.model.Book;
import com.project.bookservice.repository.BookRepository;
import com.project.bookservice.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTests {

    @Test
    @DisplayName("Calls bookRepository.findAll() and returns a Book array")
    public void getBooksTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookMapper bookMapper = mock(BookMapper.class);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(new Book(), new Book()));

        BookService bookService = new BookService(bookRepository, bookMapper);

        String result = bookService.getBooks();

        assertEquals("[Book(id=null, name=null, author=null, publisher=null), Book(id=null, name=null, author=null, publisher=null)]", result);
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Calls bookRepository.save() and returns \"book created\"")
    public void createBookTest() {
        BookRepository bookRepository = mock(BookRepository.class);
        BookMapper bookMapper = mock(BookMapper.class);

        BookService bookService = new BookService(bookRepository, bookMapper);
        BookDto book = new BookDto(0L, "test", "test", "test");

        String result = bookService.createBook(book);

        assertEquals("book created", result);
        verify(bookRepository, times(1)).save(any());
    }
}
