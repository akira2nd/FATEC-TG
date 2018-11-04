package com.fatec.tg.controller;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fatec.tg.controller.geral.UsoGeralController;
import com.fatec.tg.janelas.internas.SocioeconomicoIFrame;
import com.fatec.tg.janelas.popup.MembroFamiliarFrame;
import com.fatec.tg.model.MembroFamiliar;

@Controller
public class SocioeconomicoController extends UsoGeralController {
	
	private SocioeconomicoIFrame socioeconomicoIFrame;
	private MembroFamiliarFrame membroFamiliarFrame;
	private Set<MembroFamiliar> listaMembroFamiliar;
	
	@Autowired
	public SocioeconomicoController(SocioeconomicoIFrame socioeconomicoIFrame,
			MembroFamiliarFrame membroFamiliarFrame) {
		this.socioeconomicoIFrame = socioeconomicoIFrame;
		this.membroFamiliarFrame = membroFamiliarFrame;
		this.listaMembroFamiliar = new HashSet<>();
	}

	@Override
	public void abrir() {
		// TODO Auto-generated method stub
	}
	
	@PostConstruct
	public void listeners() {
		buttonAddAction(socioeconomicoIFrame.getButtonAddMembro(), (e) -> adicionaCampo());
		buttonAddAction(membroFamiliarFrame.getPainelMembroFamiliar().getButtonSalvar(), (e) -> populaLista());
	}

	private void populaLista() {
		MembroFamiliar membroFamiliar = new MembroFamiliar();
		membroFamiliar.setAtivo(1);
		membroFamiliar.setDataNasc(membroFamiliarFrame.getPainelMembroFamiliar().getTextDataNascimento().getDate());
		membroFamiliar.setNome(membroFamiliarFrame.getPainelMembroFamiliar().getTextFieldNome().getText());
		membroFamiliar.setParentesco(membroFamiliarFrame.getPainelMembroFamiliar().getTextFieldParentesco().getText());
		membroFamiliar.setEstudante(membroFamiliarFrame.getPainelMembroFamiliar().getRadioButtonSim().isSelected());
		membroFamiliar.setSerie(membroFamiliarFrame.getPainelMembroFamiliar().getTextFieldSerie().getText());
		membroFamiliar.setTurno(membroFamiliarFrame.getPainelMembroFamiliar().getComboBoxTurno().getSelectedItem().toString());
		membroFamiliar.setRenda(membroFamiliarFrame.getPainelMembroFamiliar().getTextFieldRenda().getText());
		//membroFamiliar.setSocioeconomico(socioeconomico);
		listaMembroFamiliar.add(membroFamiliar);
		limpar();
		membroFamiliarFrame.dispose();
		socioeconomicoIFrame.getPainelNomeMembro().add(new JLabel(membroFamiliar.getNome()));
		JPanel painelBotoes = new JPanel();
		painelBotoes.add(new JButton("Remover"));
		socioeconomicoIFrame.getPainelNomeMembro().add(painelBotoes);
		socioeconomicoIFrame.revalidate();
	}

	private void adicionaCampo() {
		membroFamiliarFrame.setVisible(true);
		limpar();
	}

	private void limpar() {
		for(Component component:membroFamiliarFrame.getPainelMembroFamiliar().getComponents()) {
			if(component instanceof JTextField) {
				((JTextField) component).setText(null);
			}
		}
		
	}

}
