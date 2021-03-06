package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class PainelSaude extends JPanel {
	
	private JTextArea textAreaSaude;
	
	public PainelSaude() {
		configPainel();
		iniciaComponentes();
	}

	private void configPainel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Informações sobre a Saúde"));
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.BOTH;
		
		textAreaSaude = new JTextArea(5, 40);
		textAreaSaude.setLineWrap(true);
		textAreaSaude.setWrapStyleWord(true);
		textAreaSaude.setBorder(BorderFactory.createTitledBorder("Observações"));
		
		add(textAreaSaude, constraints);
		
	}

}
