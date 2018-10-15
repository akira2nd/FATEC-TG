package com.fatec.tg.janelas.paineis;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.fatec.tg.model.listas.Escolaridade;
import com.fatec.tg.model.listas.EstadoCivil;
import com.toedter.calendar.JDateChooser;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class PainelResponsavelFamiliar extends JPanel {
	
	private JTextField textFieldNome;
	private JDateChooser textDataNascimento;
	private JTextField textFieldEndereco;
	private JFormattedTextField textFieldNumero;
	private JTextField textFieldComplemento;
	private JTextField textFieldBairro;
	private JComboBox<Escolaridade> comboBoxEscolaridade;
	private JComboBox<EstadoCivil> comboBoxEstadoCivil;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldRg;
	private JTextField textFieldCpf;
	private JTextField textFieldProfissao;
	private JTextField textFieldFuncao;
	private JFormattedTextField textFieldRenda;
	private JTextField textFieldRendaTotal;
	private JTextField textFieldRendaLiquida;
	
	public PainelResponsavelFamiliar() {
		
		configPainel();
		iniciaComponentes();
		
	}

	private void configPainel() {
		setLayout(new GridBagLayout());
		set
		
	}

	private void iniciaComponentes() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
