package com.fatec.tg.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fatec.tg.controller.geral.UsoGeralController;
import com.fatec.tg.janelas.internas.AtendimentoIFrame;
import com.fatec.tg.janelas.paineis.PainelCabecalho;
import com.fatec.tg.model.Atendimento;
import com.fatec.tg.model.Usuario;
import com.fatec.tg.service.AtendimentoService;
import com.fatec.tg.service.UsuarioService;

@Controller
public class AtendimentoController extends UsoGeralController {
	
	private AtendimentoIFrame atendimentoIFrame;
	private UsuarioService usuarioService;
	private AtendimentoService atendimentoService;
	private PainelCabecalho painelCabecalho;
	
	@Autowired
	public AtendimentoController(AtendimentoIFrame atendimentoIFrame,PainelCabecalho painelCabecalho, UsuarioService usuarioService, AtendimentoService atendimentoService) {
		this.atendimentoIFrame = atendimentoIFrame;
		this.painelCabecalho = painelCabecalho;
		this.usuarioService = usuarioService;
		this.atendimentoService = atendimentoService;
	}
	
	@Override
	public void abrir() {
		
	}
	
	@PostConstruct
	public void listeners() {
		buttonAddAction(atendimentoIFrame.getButtonSalvar(), (e) -> salvarAtendimento());
	}
	
	private void salvarAtendimento() {
		Usuario usuario = usuarioService.localizaUsuarioPorEmail(painelCabecalho.getLabelEmail().getText());
		Atendimento atendimento = new Atendimento();
		try {
			atendimento.setDataAtendimento(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(atendimentoIFrame.getTextFieldData().getText()));
		} catch (ParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "erro", "teste", 0);
		}
		atendimento.setEmail(atendimentoIFrame.getTextFieldEmail().getText());
		atendimento.setFormaDeContato(atendimentoIFrame.getComboBoxFormaDeContato().getSelectedItem().toString());
		atendimento.setMotivoContato(atendimentoIFrame.getComboBoxMotivo().getSelectedItem().toString());
		atendimento.setNome(atendimentoIFrame.getTextFieldNome().getText());
		atendimento.setObservacoes(atendimentoIFrame.getTextAreaObservacoes().getText());
		atendimento.setTelefone(atendimentoIFrame.getTextFieldTelefone().getText());
		atendimento.setUsuario(usuario);
		
		atendimentoService.salvar(atendimento);
		
		limparCampos();
	}


	private void limparCampos() {
		JOptionPane.showMessageDialog(null, "salvo com sucesso", "teste", JOptionPane.INFORMATION_MESSAGE);
		atendimentoIFrame.dispose();
	}

	public AtendimentoIFrame getAtendimentoIFrame() {
		return atendimentoIFrame;
	}




}
