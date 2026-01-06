package com.project.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookDto(Long id, String name, String author, String publisher) {
}
