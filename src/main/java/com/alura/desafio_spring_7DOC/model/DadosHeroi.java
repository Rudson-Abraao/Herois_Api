package com.alura.desafio_spring_7DOC.model;

import jakarta.validation.constraints.NotBlank;

public record DadosHeroi(
        Long id,
        @NotBlank
        String nomeHeroi,
        @NotBlank
        String nomeCivil,
        @NotBlank
        String universo,
        @NotBlank
        String primeiraAparicao
) {
}
