package com.fatec.tg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatec.tg.model.Atendimento;

@Repository("atendimentoRepository")
public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer> {

}
