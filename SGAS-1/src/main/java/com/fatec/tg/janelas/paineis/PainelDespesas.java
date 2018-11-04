package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class PainelDespesas extends JPanel {
	
	private JTextField textFieldAluguel;
	private JButton buttonAluguel;
	private JTextField textFieldAgua;
	private JButton buttonAgua;
	private JTextField textFieldLuz;
	private JButton buttonLuz;
	private JTextField textFieldGas;
	private JButton buttonGas;
	private JTextField textFieldTelefone;
	private JButton buttonTelefone;
	private JTextField textFieldMedicamentos;
	private JButton buttonMedicamentos;
	private JTextField textFieldTotalGastos;
	private JTextField textFieldRendaLiquida;
	
	public PainelDespesas() {
		configPainel();
		iniciaComponentes();
		
	}

	private void configPainel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Despesas Gerais"));
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		
		textFieldAluguel = new JTextField(10);
		textFieldAluguel.setBorder(BorderFactory.createTitledBorder("Aluguel"));
		buttonAluguel = new JButton("Add Comprovante");
		textFieldAgua = new JTextField(10);
		textFieldAgua.setBorder(BorderFactory.createTitledBorder("Água"));
		buttonAgua = new JButton("Add Comprovante");
		textFieldLuz = new JTextField(10);
		textFieldLuz.setBorder(BorderFactory.createTitledBorder("Luz"));
		buttonLuz = new JButton("Add Comprovante");
		textFieldGas = new JTextField(10);
		textFieldGas.setBorder(BorderFactory.createTitledBorder("Gás"));
		buttonGas = new JButton("Add Comprovante");
		textFieldTelefone = new JTextField(10);
		textFieldTelefone.setBorder(BorderFactory.createTitledBorder("Telefone"));
		buttonTelefone = new JButton("Add Comprovante");
		textFieldMedicamentos = new JTextField(10);
		textFieldMedicamentos.setBorder(BorderFactory.createTitledBorder("Medicamentos"));
		buttonMedicamentos = new JButton("Add Comprovante");
		textFieldTotalGastos = new JTextField(10);
		textFieldTotalGastos.setBorder(BorderFactory.createTitledBorder("Total de Gastos"));
		textFieldTotalGastos.setEditable(false);
		textFieldRendaLiquida= new JTextField(10);
		textFieldRendaLiquida.setBorder(BorderFactory.createTitledBorder("Renda Liquida"));
		textFieldRendaLiquida.setEditable(false);
		
		add(textFieldAluguel, constraints);
		constraints.gridy = 1;
		add(textFieldAgua, constraints);
		constraints.gridy = 2;
		add(textFieldLuz, constraints);
		
		constraints.gridy = 0;
		constraints.gridx = 1;
		add(buttonAluguel, constraints);
		constraints.gridy = 1;
		add(buttonAgua, constraints);
		constraints.gridy = 2;
		add(buttonLuz, constraints);
		
		constraints.gridy = 0;
		constraints.gridx = 2;
		add(textFieldGas, constraints);
		constraints.gridy = 1;
		add(textFieldTelefone, constraints);
		constraints.gridy = 2;
		add(textFieldMedicamentos, constraints);
		
		constraints.gridy = 0;
		constraints.gridx = 3;
		add(buttonGas, constraints);
		constraints.gridy = 1;
		add(buttonTelefone, constraints);
		constraints.gridy = 2;
		add(buttonMedicamentos, constraints);
		
		constraints.gridy = 3;
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		add(textFieldTotalGastos, constraints);
		constraints.gridx = 1;
		add(textFieldRendaLiquida, constraints);
	}

}
