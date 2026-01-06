package com.project.authorservice.mapper;

import com.project.authorservice.dto.AuthorDto;
import com.project.authorservice.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto authorToAuthorDto(Author author);
    Author authorDtoToAuthor(AuthorDto dto);
    List<AuthorDto> authorsToAuthorDtos(List<Author> authors);
}
