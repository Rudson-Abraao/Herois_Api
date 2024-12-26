package com.alura.desafio_spring_7DOC.repository;

import com.alura.desafio_spring_7DOC.model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {

}
