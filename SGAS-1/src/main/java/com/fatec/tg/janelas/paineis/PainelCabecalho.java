package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Component
public class PainelCabecalho extends JPanel {
	
	private JLabel labelUsuario;
	private JLabel labelEmail;
	
	public PainelCabecalho() {
		configPanel();
		iniciaComponentes();
	}

	private void configPanel() {
		setLayout(new GridBagLayout());
	}
	
	private void iniciaComponentes() {
		URL urlLogo1 = getClass().getResource("/imagens/logo1.png");
		URL urlLogo2 = getClass().getResource("/imagens/obra-socialfinal.png");
		URL urlLogo3 = getClass().getResource("/imagens/logo.png");
		labelUsuario = new JLabel();
		labelEmail = new JLabel();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		
		add(new JLabel(new ImageIcon(urlLogo1)),constraints);
		
		constraints.gridx = 1;
		add(new JLabel(new ImageIcon(urlLogo2)),constraints);
		
		constraints.gridx = 3;
		add(new JLabel(new ImageIcon(urlLogo3)),constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(labelUsuario,constraints);
	}
	
}
