package com.fatec.tg.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.tg.model.Atendimento;

@Controller
public class AtendimentoController {
	
	@GetMapping(value="/gas/atendimento")
	public ModelAndView novoAtendimento() {
		ModelAndView modelAndView = new ModelAndView();
		Atendimento atendimento = new Atendimento();
		atendimento.setDataAtendimento(new Date());
		modelAndView.addObject("atendimento", atendimento);
		modelAndView.setViewName("gas/atendimento");
		
		return modelAndView;
	}

}
