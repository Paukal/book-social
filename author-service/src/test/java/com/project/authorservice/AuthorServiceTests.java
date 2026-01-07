package com.project.authorservice;

import com.project.authorservice.dto.AuthorDto;
import com.project.authorservice.mapper.AuthorMapper;
import com.project.authorservice.model.Author;
import com.project.authorservice.repository.AuthorRepository;
import com.project.authorservice.service.AuthorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTests
{
    @Mock
    AuthorRepository authorRepository;

    @Mock
    AuthorMapper authorMapper;

    @InjectMocks
    AuthorService authorService;

    @Test
    @DisplayName("Calls authorRepository.findAll() and returns an Author array")
    public void getAuthorsTest() {
        when(authorRepository.findAll()).thenReturn(Arrays.asList(new Author(), new Author()));

        String result = authorService.getAuthors();

        verify(authorRepository, times(1)).findAll();
        assertEquals("[Author(id=null, firstName=null, lastName=null, code=null), Author(id=null, firstName=null, lastName=null, code=null)]",  result);
    }

    @Test
    @DisplayName("Calls authorRepository.save() and returns \"author created\"")
    public void createAuthorTest() {
        AuthorDto authorDto = new AuthorDto(0L, "Test", "Test", 0L);

        String result = authorService.createAuthor(authorDto);

        verify(authorRepository, times(1)).save(any());
        assertEquals("author created", result);
    }
}
