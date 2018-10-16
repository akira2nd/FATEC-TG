package com.fatec.tg.janelas.paineis;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class PainelHabitacao extends JPanel {
	
	private JTextField textFieldTipoHabitacao;
	private JTextField textFieldNumeroComodos;
	// TODO criar combobox com o tipo do imovel
	// proprio, alugado, emprestado, ocupado
	//TODO combo para automovel sim/não
	private JTextField textFieldMarca;
	private JTextField textFieldAno;

}
