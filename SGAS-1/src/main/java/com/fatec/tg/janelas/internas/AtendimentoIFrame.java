package com.fatec.tg.janelas.internas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.springframework.stereotype.Component;

import com.fatec.tg.model.listas.FormaDeContato;
import com.fatec.tg.model.listas.MotivoContato;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Component
public class AtendimentoIFrame extends JInternalFrame {
	
	private JButton buttonSalvar;
	private JTextField textFieldData;
	private JTextField textFieldNome;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JComboBox<MotivoContato> comboBoxMotivo;
	private JComboBox<FormaDeContato> comboBoxFormaDeContato;
	private JTextArea textAreaObservacoes;
	//private JPanel painelGeral;
	
	public AtendimentoIFrame() {
		configPanel();
		iniciaComponentes();
		pack();
	}

	private void configPanel() {
		setTitle("Novo Atendimento");
		setClosable(true);
		setLayout(new GridBagLayout());
	}

	private void iniciaComponentes() {
		buttonSalvar = new JButton("Salvar");
		textAreaObservacoes = new JTextArea(5,50);
		textFieldData = new JTextField(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()));
		textFieldEmail = new JTextField(30);
		textFieldNome = new JTextField(50);
		try {
			textFieldTelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		comboBoxFormaDeContato = new JComboBox<>(FormaDeContato.values());
		comboBoxMotivo = new JComboBox<>(MotivoContato.values());
	
		textFieldData.setEditable(false);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		add(textFieldData, constraints);
		constraints.gridy = 1;
		add(textFieldNome, constraints);
		constraints.gridy = 2;
		add(textFieldEmail, constraints);
		constraints.gridy = 3;
		add(textFieldTelefone, constraints);
		constraints.gridy = 4;
		add(comboBoxFormaDeContato, constraints);
		constraints.gridx = 1;
		add(comboBoxMotivo, constraints);
		constraints.gridy = 5;
		constraints.gridx = 0;
		add(textAreaObservacoes, constraints);
		constraints.gridy = 6;
		add(buttonSalvar, constraints);
	}

}
