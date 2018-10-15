package com.fatec.tg.janelas.mestre;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class LoginFrame extends JFrame{
	
	private JButton buttonLogar;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	
	public LoginFrame() {
		configFrame();
		iniciaComponentes();
		pack();
		setLocationRelativeTo(null);
	}

	private void configFrame() {
		setTitle("SGAS - Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new GridBagLayout());
	}

	private void iniciaComponentes() {
		buttonLogar = new JButton("Entrar");
		textFieldUsuario = new JTextField(30);
		passwordField = new JPasswordField(30);
		
		textFieldUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Usuário"));
		passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Senha"));
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		
		add(textFieldUsuario, constraints);
		constraints.gridy = 1;
		add(passwordField, constraints);
		constraints.gridy = 2;
		add(buttonLogar,constraints);
		
	}
}
