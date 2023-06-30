package com.lista.livros.dto;

import jakarta.validation.constraints.NotBlank;

//Dentro do parênteses é preciso informar como parâmetro todos os atributos q serão utilizados.
public record BookListDto(
        @NotBlank
        String name,
        @NotBlank
        String writer,
        @NotBlank
        String publisher,
        @NotBlank
        String year,
        @NotBlank
        String finished) {
}
