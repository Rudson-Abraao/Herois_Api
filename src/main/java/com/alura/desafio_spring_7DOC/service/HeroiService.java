package com.alura.desafio_spring_7DOC.service;

import com.alura.desafio_spring_7DOC.model.DadosAtualizacaoHeroi;
import com.alura.desafio_spring_7DOC.model.DadosHeroi;
import com.alura.desafio_spring_7DOC.model.Heroi;
import com.alura.desafio_spring_7DOC.repository.HeroiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HeroiService {
    @Autowired
    private HeroiRepository repository;

    public void salvaNoBanco(Heroi heroi){

    }

    public void salvaNoBanco(@RequestBody  @Valid List<DadosHeroi> dados) {
        List<Heroi> herois = dados.stream()
                .map(d -> new Heroi(d.nomeHeroi(),d.nomeCivil(),d.universo(),d.primeiraAparicao()))
                .collect(Collectors.toList());

        repository.saveAll(herois);
    }

    public DadosHeroi pegaDoBanco(Long id) {
        Optional<Heroi> heroiEncontrado = repository.findById(id);
        if (heroiEncontrado.isPresent()){
            Heroi h = heroiEncontrado.get();
            return new DadosHeroi(heroiEncontrado.get().getId(),h.getNomeHeroi(),h.getNomeCivil(),h.getUniverso(),h.getPrimeiraAparicao());
        }
        return null;

    }


    public void atualizaHeroi(@Valid DadosAtualizacaoHeroi dados) {
        Optional<Heroi> heroi = repository.findById(dados.id());
        if (heroi.isPresent()){
            Heroi heroiEcontrado = heroi.get();
            System.out.println(dados.nomeCivil());
            heroiEcontrado.atualizaCadastro(dados);

        }
    }

    public void deletarHeroi(Long id) {
        repository.deleteById(id);
    }


    public Page<DadosHeroi> listaTodosHerois(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(h -> new DadosHeroi(h.getId(),h.getNomeHeroi(),h.getNomeCivil(),h.getUniverso(),h.getPrimeiraAparicao()));
    }
}
