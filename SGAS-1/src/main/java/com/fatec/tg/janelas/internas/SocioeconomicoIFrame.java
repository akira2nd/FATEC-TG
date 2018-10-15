package com.fatec.tg.janelas.internas;

import javax.swing.JButton;
import javax.swing.JInternalFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.janelas.paineis.PainelResponsavelFamiliar;

@SuppressWarnings("serial")
@Component
public class SocioeconomicoIFrame extends JInternalFrame{
	
	private PainelResponsavelFamiliar painelResponsavel;
	private PainelMembroFamiliar painelMembro;
	private PainelHabitacao painelHabitacao;
	private PainelSaude painelSaude;
	private PainelDespesas painelDespesas;
	private JButton buttonSalvar;
	
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
	
	private void configFrame() {
		// TODO Auto-generated method stub
		
	}
	private void iniciaComponentes() {
		// TODO Auto-generated method stub
		
	}
	
	


}
