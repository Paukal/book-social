package com.project.authorservice.service;

import com.project.authorservice.dto.AuthorDto;
import com.project.authorservice.mapper.AuthorMapper;
import com.project.authorservice.model.Author;
import com.project.authorservice.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper; // Injected by Spring

    public String getAuthors() {
        return authorRepository.findAll().toString();
    }

    public String createAuthor(AuthorDto authorDto) {
        authorRepository.save(getAuthorEntity(authorDto));
        return "author created";
    }

    public AuthorDto getAuthorDto(Author author) {
        return authorMapper.authorToAuthorDto(author);
    }

    public Author getAuthorEntity(AuthorDto authorDto) {
        return authorMapper.authorDtoToAuthor(authorDto);
    }
}
