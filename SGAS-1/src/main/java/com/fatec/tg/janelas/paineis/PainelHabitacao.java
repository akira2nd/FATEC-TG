package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.fatec.tg.model.listas.TipoImovel;

@SuppressWarnings("serial")
@Component
public class PainelHabitacao extends JPanel {
	
	private JTextField textFieldTipoHabitacao;
	private JTextField textFieldNumeroComodos;
	private JComboBox<TipoImovel> comboBoxTipoImovel;
	private JComboBox<String> temAutomovel;
	private JTextField textFieldMarca;
	private JTextField textFieldAno;

	public PainelHabitacao() {
		configPainel();
		iniciaComponentes();
	}

	private void configPainel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Habitação / Veículo"));
		
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		Vector<String> opcao = new Vector<>();
		opcao.add("SIM");
		opcao.add("NÃO");
		
		textFieldTipoHabitacao = new JTextField(30);
		textFieldTipoHabitacao.setBorder(BorderFactory.createTitledBorder("Tipo de Construção"));
		textFieldNumeroComodos = new JTextField(10);
		textFieldNumeroComodos.setBorder(BorderFactory.createTitledBorder("Nº de comodos"));
		comboBoxTipoImovel = new JComboBox<>(TipoImovel.values());
		comboBoxTipoImovel.setBorder(BorderFactory.createTitledBorder("Situação do imovel"));
		temAutomovel = new JComboBox<>(opcao);
		temAutomovel.setBorder(BorderFactory.createTitledBorder("Possui Automóvel"));
		textFieldMarca = new JTextField(30);
		textFieldMarca.setBorder(BorderFactory.createTitledBorder("Marca"));
		textFieldAno = new JTextField(8);
		textFieldAno.setBorder(BorderFactory.createTitledBorder("Ano"));
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(textFieldTipoHabitacao, constraints);
		constraints.gridy = 1;
		add(comboBoxTipoImovel, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(textFieldNumeroComodos, constraints);
		constraints.gridy = 1;
		add(temAutomovel, constraints);
		constraints.gridx = 2;
		add(textFieldMarca, constraints);
		constraints.gridx = 3;
		add(textFieldAno, constraints);
	}
}
