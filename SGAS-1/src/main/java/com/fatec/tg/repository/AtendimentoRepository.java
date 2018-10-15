package com.fatec.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.tg.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{

}
