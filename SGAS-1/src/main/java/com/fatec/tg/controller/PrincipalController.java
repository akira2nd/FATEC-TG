package com.fatec.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fatec.tg.controller.geral.UsoGeralController;
import com.fatec.tg.janelas.mestre.PrincipalFrame;
import com.fatec.tg.model.Usuario;

import lombok.Setter;

@Controller
public class PrincipalController extends UsoGeralController {

	private PrincipalFrame principalFrame;
	private AtendimentoController atendimentoController;
	@Setter
	private Usuario usuario;


	@Autowired
	public PrincipalController(PrincipalFrame principalFrame,AtendimentoController atendimentoController) {
		this.principalFrame = principalFrame;
		this.atendimentoController = atendimentoController;
		this.usuario = new Usuario();
		//this.usuario = usuario;
	}

	@Override
	public void abrir() {
		menuAddActionListener(principalFrame.getPainelMenu().getMenuItemAtendimento(), (e) -> abrirAtendimento());
		menuAddActionListener(principalFrame.getPainelMenu().getMenuItemRelatorio(), (e) -> abrirRelatorio());
		menuAddActionListener(principalFrame.getPainelMenu().getMenuItemServico(), (e) -> abrirServico());
		menuAddActionListener(principalFrame.getPainelMenu().getMenuItemSocioeconomico(), (e) -> abrirSocioeconomico());
		principalFrame.getPainelCabecalho().getLabelUsuario().setText("Bem Vindo! "+ usuario.getNome());
		principalFrame.getPainelCabecalho().getLabelEmail().setText(usuario.getEmail());
		principalFrame.setVisible(true);
	}

	private void abrirSocioeconomico() {
		// TODO arrumar
		System.out.println("socioeconomico");
		

	}

	private void abrirServico() {
		// TODO Auto-generated method stub
		System.out.println("servico");
		
	}

	private void abrirRelatorio() {
		// TODO Auto-generated method stub
		System.out.println("relatorio");
		
	}

	private void abrirAtendimento() {
		// TODO Auto-generated method stub
		principalFrame.getAtendimentoIFrame().setVisible(true);
		System.out.println("funcionou!!!!!");

	}
	
}
