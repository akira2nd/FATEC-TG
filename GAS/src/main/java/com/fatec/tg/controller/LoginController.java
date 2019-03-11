package com.fatec.tg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.tg.model.Usuario;
import com.fatec.tg.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value= {"/","/login"})
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@GetMapping(value="/registrar")
	public ModelAndView entrar() {
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuario = new Usuario();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("registrar");
		return modelAndView;
	}
	
	@PostMapping(value="/registrar")
	public ModelAndView novoUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuarioExiste = usuarioService.localizaUsuarioPorEmail(usuario.getEmail());
		if(usuarioExiste != null) {
			bindingResult.rejectValue("email", "error.usuario", "Já existe esse e-mail cadastrado no sistema");
		}
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("registrar");
		}else {
			usuarioService.salvarUsuario(usuario);
			modelAndView.addObject("msgSucesso", "Usuário cadastrado com sucesso");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.setViewName("registrar");
		}
		
		return modelAndView;
	}
	
	@GetMapping(value="/gas/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuario = usuarioService.localizaUsuarioPorEmail(auth.getName());
		modelAndView.addObject("usuarioNome", "Bem Vindo " + usuario.getNome() + " --- " + usuario.getEmail());
		modelAndView.addObject("msgAdmin", "Conteúdo disponivel para administrador");
		modelAndView.setViewName("gas/home");
		return modelAndView;
	}

}
