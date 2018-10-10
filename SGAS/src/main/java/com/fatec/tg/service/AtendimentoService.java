package com.fatec.tg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.tg.model.Atendimento;
import com.fatec.tg.repository.AtendimentoRepository;

@Service("atendimentoService")
@Transactional
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public void salvarAtendimento(Atendimento atendimento) {
		this.atendimentoRepository.save(atendimento);
	}
	
}
