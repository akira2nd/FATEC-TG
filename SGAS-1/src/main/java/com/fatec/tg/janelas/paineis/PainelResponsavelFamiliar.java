package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

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
	
	private JTextField textFieldCpf;
	private JTextField textFieldRg;
	
	private JComboBox<EstadoCivil> comboBoxEstadoCivil;
	private JComboBox<Escolaridade> comboBoxEscolaridade;
	
	private JTextField textFieldProfissao;
	private JTextField textFieldFuncao;
	private JFormattedTextField textFieldRenda;
	
	private JFormattedTextField textFieldTelefone;
	
	private JTextField textFieldEndereco;
	private JTextField textFieldNumero;
	private JTextField textFieldComplemento;
	
	private JTextField textFieldBairro;


	private JTextField textFieldRendaTotal;
	private JTextField textFieldRendaLiquida;

	public PainelResponsavelFamiliar() {
		configPainel();
		iniciaComponentes();

	}

	private void configPainel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dados do Responsável familiar"));
	}

	private void iniciaComponentes() {
		JPanel painelRendaTotal = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTHWEST;

		textFieldNome = new JTextField(60);
		textFieldNome.setBorder(BorderFactory.createTitledBorder("Nome"));
		textDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		textDataNascimento.setBorder(BorderFactory.createTitledBorder("Data de nascimento"));
		// textDataNascimento.setDate(new Date());
		/*
		textDataNascimento.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				((JTextFieldDateEditor) e.getSource()).selectAll();
			}
		});
		 */
		textFieldEndereco = new JTextField(60);
		textFieldEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		try {
			MaskFormatter formatoTelefone = new MaskFormatter("(##)#####-####");
			formatoTelefone.setPlaceholderCharacter('_');
			textFieldTelefone = new JFormattedTextField(formatoTelefone);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		textFieldTelefone.setBorder(BorderFactory.createTitledBorder("Celular"));
		NumberFormat numero = NumberFormat.getNumberInstance();
		DecimalFormat decimal = (DecimalFormat) numero;
		decimal.setGroupingUsed(false);
		textFieldNumero = new JTextField(5);
		textFieldNumero.setBorder(BorderFactory.createTitledBorder("Nº"));
		textFieldRenda = new JFormattedTextField(numero);
		textFieldRenda.setColumns(5);
		textFieldRenda.setBorder(BorderFactory.createTitledBorder("Renda R$"));
		
		textFieldComplemento = new JTextField(20);
		textFieldComplemento.setBorder(BorderFactory.createTitledBorder("Complemento"));
		textFieldBairro = new JTextField(40);
		textFieldBairro.setBorder(BorderFactory.createTitledBorder("Bairro"));
		comboBoxEscolaridade = new JComboBox<>(Escolaridade.values());
		comboBoxEscolaridade.setBorder(BorderFactory.createTitledBorder("Escolaridade"));
		comboBoxEstadoCivil = new JComboBox<>(EstadoCivil.values());
		comboBoxEstadoCivil.setBorder(BorderFactory.createTitledBorder("Estado Civil"));

		textFieldRg = new JTextField(10);
		textFieldRg.setBorder(BorderFactory.createTitledBorder("RG"));
		textFieldCpf = new JTextField(12);
		textFieldCpf.setBorder(BorderFactory.createTitledBorder("CPF"));
		textFieldProfissao = new JTextField(30);
		textFieldProfissao.setBorder(BorderFactory.createTitledBorder("Profissão"));
		textFieldFuncao = new JTextField(30);
		textFieldFuncao.setBorder(BorderFactory.createTitledBorder("Função"));

		textFieldRendaTotal = new JTextField(11);
		textFieldRendaTotal.setEditable(false);
		textFieldRendaTotal.setBorder(BorderFactory.createTitledBorder("Renda Total"));
		textFieldRendaLiquida = new JTextField(11);
		textFieldRendaLiquida.setEditable(false);
		textFieldRendaLiquida.setBorder(BorderFactory.createTitledBorder("Renda Liquida"));
		
		constraints.gridx = 0;
		add(textFieldNome, constraints);
		painelRendaTotal.add(textFieldRendaTotal, constraints);
		constraints.gridy = 1;
		painelRendaTotal.add(textFieldRendaLiquida, constraints);
		add(textFieldCpf, constraints);
		constraints.gridy = 2;
		add(comboBoxEstadoCivil, constraints);
		constraints.gridy = 3;
		add(textFieldProfissao, constraints);
		constraints.gridy = 4;
		add(textFieldTelefone, constraints);
		constraints.gridy = 5;
		add(textFieldEndereco, constraints);
		constraints.gridy = 6;
		add(textFieldBairro, constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		add(textDataNascimento, constraints);
		constraints.gridy = 1;
		add(textFieldRg, constraints);
		constraints.gridy = 2;
		add(comboBoxEscolaridade, constraints);
		constraints.gridy = 3;
		add(textFieldFuncao, constraints);
		constraints.gridy = 5;
		add(textFieldNumero, constraints);

		constraints.gridx = 2;
		constraints.gridy = 3;
		add(textFieldRenda, constraints);
		constraints.gridy = 5;
		add(textFieldComplemento, constraints);

		constraints.gridheight = 6;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 3;
		constraints.gridy = 0;
		add(painelRendaTotal, constraints);

	}

}
