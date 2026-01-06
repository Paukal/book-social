package com.project.authorservice.controller;

import com.project.authorservice.dto.AuthorDto;
import com.project.authorservice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/author-info")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/author")
    public String getAuthor() {
        return "author";
    }

    @GetMapping("/authors")
    public String getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/author")
    public String createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }

    @PostMapping("/authors")
    public String createAuthors() {
        return "post authors";
    }
}
