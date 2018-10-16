package com.fatec.tg.janelas.internas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JInternalFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.janelas.paineis.PainelDespesas;
import com.fatec.tg.janelas.paineis.PainelHabitacao;
import com.fatec.tg.janelas.paineis.PainelMembroFamiliar;
import com.fatec.tg.janelas.paineis.PainelResponsavelFamiliar;
import com.fatec.tg.janelas.paineis.PainelSaude;

@SuppressWarnings("serial")
@Component
public class SocioeconomicoIFrame extends JInternalFrame{
	
	private PainelResponsavelFamiliar painelResponsavel;
	private PainelMembroFamiliar painelMembro;
	private PainelHabitacao painelHabitacao;
	private PainelSaude painelSaude;
	private PainelDespesas painelDespesas;
	//private JButton buttonSalvar;
	
	
	/*
	@Autowired
	public SocioeconomicoIFrame(PainelResponsavelFamiliar painelResponsavel, PainelMembroFamiliar painelMembro,
			PainelHabitacao painelHabitacao, PainelSaude painelSaude, PainelDespesas painelDespesas) {
		this.painelResponsavel = painelResponsavel;
		this.painelMembro = painelMembro;
		this.painelHabitacao = painelHabitacao;
		this.painelSaude = painelSaude;
		this.painelDespesas = painelDespesas;
		
		configFrame();
		iniciaComponentes();
		pack();
	}
	*/
	
	@Autowired
	public SocioeconomicoIFrame(PainelResponsavelFamiliar painelResponsavel) {
		this.painelResponsavel = painelResponsavel;
		
		configFrame();
		iniciaComponentes();
		pack();
	}

	private void configFrame() {
		setTitle("Novo Cadastro Socioeconomico");
		setClosable(true);
		setLayout(new GridBagLayout());
		
	}
	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.WEST;
		
		add(painelResponsavel, constraints);
		
	}
	
	


}
