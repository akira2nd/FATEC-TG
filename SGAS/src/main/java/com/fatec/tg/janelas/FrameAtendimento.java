package com.fatec.tg.janelas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.model.Atendimento;
import com.fatec.tg.model.FormaDeContato;
import com.fatec.tg.model.MotivoContato;
import com.fatec.tg.service.AtendimentoService;

@Component
public class FrameAtendimento extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private AtendimentoService atendimentoService;
	
	//private Usuario usuario;
	
	private JPanel painelGeral = new JPanel(new GridBagLayout());
	private JPanel painelFormulario = new JPanel(new GridBagLayout());
	private JPanel painelSave = new JPanel(new GridBagLayout());
	private JTextField textFieldData = new JTextField(20);
	private JTextField textFieldNome = new JTextField(50);
	private JTextField textFieldTelefone = new JTextField(10);
	private JTextField textFieldEmail = new JTextField(30);
	private JComboBox<MotivoContato> comboBoxMotivo = new JComboBox<>(MotivoContato.values());
	private JComboBox<FormaDeContato> comboBoxFormaDeContato = new JComboBox<>(FormaDeContato.values());
	private JTextArea textAreaObservacoes = new JTextArea(5, 50);
	
	private SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
	

	public FrameAtendimento() {
		super("Novo Atendimento",false,true,false);
		
		//this.usuario = usuario;
		
		JButton buttonSalvar = new JButton("Salvar");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		
		textFieldData.setText(dataFormatada.format(new Date()));
		textFieldData.setEnabled(false);
		
		
		painelGeral.add(painelFormulario, constraints);
		painelFormulario.add(textFieldData, constraints);
		
		buttonSalvar.setActionCommand("salvar");
		buttonSalvar.addActionListener(this);
		painelSave.add(buttonSalvar,constraints);
		
		constraints.gridy = 1;
		painelFormulario.add(textFieldNome,constraints);
		
		constraints.gridy = 2;
		painelFormulario.add(textFieldTelefone,constraints);
		
		constraints.gridy = 3;
		painelFormulario.add(textFieldEmail,constraints);
		
		constraints.gridy = 4;
		painelFormulario.add(comboBoxMotivo, constraints);
		
		constraints.gridy = 5;
		painelFormulario.add(comboBoxFormaDeContato, constraints);
		
		constraints.gridy = 6;
		painelFormulario.add(textAreaObservacoes, constraints);
		
		constraints.gridy = 0;
		constraints.gridx = 1;
		painelGeral.add(painelSave, constraints);
		
		add(painelGeral, BorderLayout.PAGE_START);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "salvar":
			
			Atendimento atendimento = new Atendimento();
			
			atendimento.setNome(textFieldNome.getText().toString());
			atendimento.setTelefone(textFieldTelefone.getText().toString());
			atendimento.setEmail(textFieldEmail.getText().toString());
			atendimento.setMotivoContato(comboBoxMotivo.getSelectedItem().toString());
			atendimento.setFormaDeContato(comboBoxFormaDeContato.getSelectedItem().toString());
			atendimento.setObservacoes(textAreaObservacoes.getText().toString());
			//atendimento.setUsuario(usuario);
			atendimentoService.salvarAtendimento(atendimento);
			
			dispose();
			
			break;

		default:
			break;
		}
		
	}

}
