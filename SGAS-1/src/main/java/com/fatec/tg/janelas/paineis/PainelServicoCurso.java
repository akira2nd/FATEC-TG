package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import lombok.Getter;

@SuppressWarnings("serial")
@Component
@Getter
public class PainelServicoCurso extends JPanel {

	private JComboBox<String> comboBoxCursos;

	public PainelServicoCurso() {
		configPainel();
		iniciaComponentes();
	}

	private void configPainel() {
		setBorder(BorderFactory.createTitledBorder("Serviços / Cursos"));
		setLayout(new GridBagLayout());
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;

		comboBoxCursos = new JComboBox<>();
		comboBoxCursos.setBorder(BorderFactory.createTitledBorder("Selecione o serviço / curso"));

		add(comboBoxCursos, constraints);
	}
}
