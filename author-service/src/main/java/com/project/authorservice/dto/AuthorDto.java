package com.project.authorservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthorDto(Long id, String firstName, String lastName, Long code) {
}
