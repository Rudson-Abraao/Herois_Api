package com.alura.desafio_spring_7DOC.model;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoHeroi (@NotNull
                                     Long id,
                                     String nomeCivil,
                                     String universo,
                                     String primeiraAparicao){
}
