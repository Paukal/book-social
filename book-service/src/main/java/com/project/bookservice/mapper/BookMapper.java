package com.project.bookservice.mapper;

import com.project.bookservice.dto.BookDto;
import com.project.bookservice.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto bookToBookDto(Book book);
    Book bookDtoToBook(BookDto dto);
    List<BookDto> booksToBookDtos(List<Book> books);
}
