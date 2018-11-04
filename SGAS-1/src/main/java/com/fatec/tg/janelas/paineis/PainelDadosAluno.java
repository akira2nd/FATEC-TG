package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.fatec.tg.model.listas.Escolaridade;

import lombok.Getter;

@SuppressWarnings("serial")
@Component
@Getter
public class PainelDadosAluno extends JPanel {
	
	private JComboBox<String> comboBoxMembroFamiliar;
	private JTextField textFieldNome;
	private JTextField textFieldRg;
	private JTextField textFieldCpf;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelContato;
	private JComboBox<String> comboBoxPossuiPc;
	private JTextField textFieldEmail;
	private JComboBox<Escolaridade> comboBoxEscolaridade;
	private JTextField textFieldProfissao;
	private JTextField textFieldNecessiadeEspecial;
	
	public PainelDadosAluno() {
		configPainel();
		iniciaComponentes();
	}

	private void configPainel() {
		setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));
		setLayout(new GridBagLayout());
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		
		comboBoxMembroFamiliar = new JComboBox<>();
		comboBoxMembroFamiliar.setBorder(BorderFactory.createTitledBorder("Membro Familiar"));
		textFieldNome = new JTextField(50);
		textFieldNome.setBorder(BorderFactory.createTitledBorder("Nome"));
		textFieldRg = new JTextField(15);
		textFieldRg.setBorder(BorderFactory.createTitledBorder("RG"));
		textFieldCpf = new JTextField(15);
		textFieldCpf.setBorder(BorderFactory.createTitledBorder("CPF"));
		textFieldEndereco = new JTextField(50);
		textFieldEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		textFieldTelContato = new JTextField(25);
		textFieldTelContato.setBorder(BorderFactory.createTitledBorder("Telefone para Contato"));
		Vector<String> simNao = new Vector<>();
		simNao.add("SIM");
		simNao.add("NÃO");
		comboBoxPossuiPc = new JComboBox<>(simNao);
		comboBoxPossuiPc.setBorder(BorderFactory.createTitledBorder("Tem computador?"));
		textFieldEmail = new JTextField(20);
		textFieldEmail.setBorder(BorderFactory.createTitledBorder("E-mail"));
		comboBoxEscolaridade = new JComboBox<>(Escolaridade.values());
		comboBoxEscolaridade.setBorder(BorderFactory.createTitledBorder("Escolaridade"));
		textFieldProfissao = new JTextField(20);
		textFieldProfissao.setBorder(BorderFactory.createTitledBorder("Profissão"));
		textFieldNecessiadeEspecial = new JTextField(40);
		textFieldNecessiadeEspecial.setBorder(BorderFactory.createTitledBorder("Necessidades especiais"));
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(comboBoxMembroFamiliar, constraints);
		constraints.gridx = 1;
		add(textFieldNome, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(textFieldRg, constraints);
		constraints.gridx = 2;
		add(textFieldCpf, constraints);
		
		constraints.gridx = 1;
		constraints.gridy=2;
		constraints.gridwidth = 2;
		add(textFieldEndereco, constraints);
		
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		add(textFieldTelContato, constraints);
		
		constraints.gridy = 4;
		add(comboBoxPossuiPc, constraints);
		
		constraints.gridy = 5;
		add(textFieldEmail, constraints);
		
		constraints.gridy = 6;
		add(comboBoxEscolaridade, constraints);
		
		constraints.gridy = 7;
		add(textFieldProfissao, constraints);
		
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		add(textFieldNecessiadeEspecial, constraints);
		
		
	}

}
