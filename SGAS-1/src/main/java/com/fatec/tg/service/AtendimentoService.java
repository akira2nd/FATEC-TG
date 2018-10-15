package com.fatec.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.tg.model.Atendimento;
import com.fatec.tg.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	private AtendimentoRepository atendimentoRepository;

	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}
	
	public void salvar(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);
	}
	
	public List<Atendimento> listar(){
		return atendimentoRepository.findAll();
	}
	

}
