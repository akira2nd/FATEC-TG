package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.toedter.calendar.JDateChooser;

import lombok.Getter;


@SuppressWarnings("serial")
@Component
@Getter
public class PainelResponsavel extends JPanel {
	
	private JTextField textFieldNome;
	private JTextField textFieldRg;
	private JTextField textFieldCpf;
	private JTextField textFieldEndereco;
	private JDateChooser textDataNascimento;
	private JButton buttonCpf;
	
	public PainelResponsavel() {
		configPainel();
		iniciaComponentes();
	}

	private void configPainel() {
		setBorder(BorderFactory.createTitledBorder("Responsável Familiar"));
		setLayout(new GridBagLayout());
		
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		
		textFieldNome = new JTextField(60);
		textFieldNome.setBorder(BorderFactory.createTitledBorder("Nome"));
		textFieldRg = new JTextField(10);
		textFieldRg.setBorder(BorderFactory.createTitledBorder("RG"));
		textFieldCpf = new JTextField(12);
		textFieldCpf.setBorder(BorderFactory.createTitledBorder("CPF"));
		textFieldEndereco = new JTextField(80);
		textFieldEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		textDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		textDataNascimento.setBorder(BorderFactory.createTitledBorder("Data de Nascimento"));
		buttonCpf = new JButton("procurar");
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		add(textFieldNome, constraints);
		constraints.gridx = 1;
		add(textDataNascimento, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(textFieldRg, constraints);
		constraints.gridx = 1;
		add(textFieldCpf, constraints);
		constraints.gridx = 2;
		add(buttonCpf, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		add(textFieldEndereco, constraints);
		
	}
	

}
