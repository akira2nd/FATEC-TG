package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.fatec.tg.model.listas.Turno;
import com.toedter.calendar.JDateChooser;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class PainelMembroFamiliar extends JPanel {
	
	private JTextField textFieldNome;
	private JDateChooser textDataNascimento;
	private JTextField textFieldParentesco;
	private JRadioButton radioButtonSim;
	private JRadioButton radioButtonNao;
	private JTextField textFieldSerie;
	private JTextField textFieldRenda;
	private JComboBox<Turno> comboBoxTurno;
	private JButton buttonSalvar;
	
	//TODO vou precisar mudar para uma janela pop-up que adiciona em uma lista
	
	public PainelMembroFamiliar() {
		configPainel();
		iniciaComponentes();
	}

	private void configPainel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dados do Componente"));
	}

	private void iniciaComponentes() {
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
				
		textFieldNome = new JTextField(50);
		textFieldNome.setBorder(BorderFactory.createTitledBorder("Nome"));
		textDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		textDataNascimento.setBorder(BorderFactory.createTitledBorder("Data de nascimento"));
		textFieldParentesco = new JTextField(40);
		textFieldParentesco.setBorder(BorderFactory.createTitledBorder("Parentesco"));
		
		radioButtonSim = new JRadioButton("Sim");
		radioButtonNao = new JRadioButton("Não");
		ButtonGroup buttonGroupEstudante = new ButtonGroup();
		buttonGroupEstudante.add(radioButtonSim);
		buttonGroupEstudante.add(radioButtonNao);
		
		textFieldSerie = new JTextField(15);
		textFieldSerie.setBorder(BorderFactory.createTitledBorder("Série"));
		
		textFieldRenda =  new JTextField(8);
		textFieldRenda.setBorder(BorderFactory.createTitledBorder("Renda"));
		
		comboBoxTurno = new JComboBox<>(Turno.values());
		comboBoxTurno.setBorder(BorderFactory.createTitledBorder("Turno"));
								
		buttonSalvar = new JButton("Salvar");
		
		add(textFieldNome,constraints);
		constraints.gridy = 1;
		add(textFieldParentesco, constraints);
		constraints.gridy = 2;
		add(textFieldRenda, constraints);
		
		constraints.gridy = 0;
		constraints.gridx = 1;
		add(textDataNascimento, constraints);
		constraints.gridy = 1;
		add(radioButtonSim, constraints);		
		constraints.gridy = 2;
		add(radioButtonNao,constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		add(textFieldSerie, constraints);
		constraints.gridy = 2;
		add(comboBoxTurno, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(buttonSalvar, constraints);
				
				
	}
	
}
