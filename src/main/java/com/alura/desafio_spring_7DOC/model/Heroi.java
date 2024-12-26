package com.alura.desafio_spring_7DOC.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "herois")

//@Getter
//@NoArgsConstructor
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeHeroi;
    private String nomeCivil;
    private String universo;
    private String primeiraAparicao;

    public Heroi(){}

    public Heroi(String nomeHeroi, String nomeCivil, String universo, String primeiraAparicao) {
        this.nomeHeroi = nomeHeroi;
        this.nomeCivil = nomeCivil;
        this.universo = universo;
        this.primeiraAparicao = primeiraAparicao;
    }

    public Long getId() {
        return id;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public String getNomeCivil() {
        return nomeCivil;
    }

    public String getUniverso() {
        return universo;
    }

    public String getPrimeiraAparicao() {
        return primeiraAparicao;
    }

    public void atualizaCadastro(@Valid DadosAtualizacaoHeroi dados) {
        if(dados.nomeCivil() != null){
            this.nomeCivil = dados.nomeCivil();
        }

        if(dados.universo() != null){
            this.universo = dados.universo();
        }

        if(dados.primeiraAparicao() != null){
            this.primeiraAparicao = dados.primeiraAparicao();
        }
    }
}
