package com.fatec.tg.janelas.paineis;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
@Component
public class PainelMembroFamiliar extends JPanel {
	
	private JTextField textFieldNome;
	private JDateChooser textDataNascimento;
	private JTextField textFieldParentesco;
	// TODO inserir combo box estuda sim/não
	private JTextField textFieldSerie;
	private JTextField textFieldRenda;
	// TODO inserir combo ou enum turno escolar
	private JButton buttonSalvar;
	
	//TODO vou precisar mudar para uma janela pop-up que adiciona em uma lista
	
}
