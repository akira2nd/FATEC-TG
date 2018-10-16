package com.fatec.tg.janelas.mestre;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.janelas.internas.AtendimentoIFrame;
import com.fatec.tg.janelas.internas.SocioeconomicoIFrame;
import com.fatec.tg.janelas.paineis.PainelCabecalho;
import com.fatec.tg.janelas.paineis.PainelMenu;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Component
public class PrincipalFrame extends JFrame {
	
	private PainelCabecalho painelCabecalho;
	private PainelMenu painelMenu;
	private AtendimentoIFrame atendimentoIFrame;
	private SocioeconomicoIFrame socioeconomicoIFrame;
	private JPanel painelGeral;

	
	@Autowired
	public PrincipalFrame(PainelCabecalho painelCabecalho, PainelMenu painelMenu, AtendimentoIFrame atendimentoIFrame, SocioeconomicoIFrame socioeconomicoIFrame)
			throws HeadlessException {
		this.painelCabecalho = painelCabecalho;
		this.painelMenu = painelMenu;
		
		this.atendimentoIFrame = atendimentoIFrame;
		this.socioeconomicoIFrame = socioeconomicoIFrame;
		
		configFrame();
		iniciaComponentes();
		pack();
	}

	private void configFrame() {
		setTitle("SGAS - Sistema Gerenciador de Atendimento e Serviços");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void iniciaComponentes() {
		//painelInterno.add(new JTextField(20));
		painelGeral = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor = GridBagConstraints.PAGE_START;
		constraints.fill = GridBagConstraints.BOTH;
		painelGeral.add(painelCabecalho,constraints);
		constraints.gridy = 1;
		painelGeral.add(painelMenu,constraints);
		constraints.gridy = 2;
		painelGeral.add(atendimentoIFrame,constraints);
		painelGeral.add(socioeconomicoIFrame,constraints);
		add(painelGeral,BorderLayout.PAGE_START);
	}

}
