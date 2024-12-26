package com.alura.desafio_spring_7DOC.controller;

import com.alura.desafio_spring_7DOC.model.DadosAtualizacaoHeroi;
import com.alura.desafio_spring_7DOC.model.DadosHeroi;
import com.alura.desafio_spring_7DOC.model.Heroi;
import com.alura.desafio_spring_7DOC.service.HeroiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    @Autowired
    private HeroiService service;

    @PostMapping
    public void recebeHeroi(@RequestBody @Valid List<DadosHeroi> dados){
        service.salvaNoBanco(dados);
    }

    @GetMapping("/{id}")
    public DadosHeroi enviaHeroi(@PathVariable Long id){
       return service.pegaDoBanco(id);
    }


    @PutMapping
    @Transactional
    public void atualiza(@RequestBody @Valid DadosAtualizacaoHeroi dados){
        System.out.println(dados);
        service.atualizaHeroi(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        service.deletarHeroi(id);

    }

    @GetMapping("/lista")
    public Page<DadosHeroi> listaHerois(Pageable paginacao){
        return service.listaTodosHerois(paginacao);

    }
}
