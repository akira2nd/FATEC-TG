package com.fatec.tg.janelas.paineis;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class PainelMenu extends JPanel {
	
	private JMenuBar menuBar;
	private JMenu menuAtendimento;
	private JMenuItem menuItemAtendimento;
	private JMenu menuSocioeconomico;
	private JMenuItem menuItemSocioeconomico;
	private JMenu menuServico;
	private JMenuItem menuItemServico;
	private JMenu menuRelatorio;
	private JMenuItem menuItemRelatorio;
	
	public PainelMenu() {
		configPanel();
		iniciaComponentes();
	}

	private void configPanel() {
		setLayout(new GridBagLayout());
	}

	private void iniciaComponentes() {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.CENTER;
		
		menuBar = new JMenuBar();
		menuAtendimento = new JMenu("Atendimento ");
		menuItemAtendimento = new JMenuItem("Novo Atendimento");
		menuRelatorio = new JMenu("Relatório ");
		menuItemRelatorio = new JMenuItem("*******");
		menuServico = new JMenu("Serviços/Cursos ");
		menuItemServico = new JMenuItem("Novo Cadastro Serviço/Curso");
		menuSocioeconomico = new JMenu("Acompanhamento_Socioeconomico ");
		menuItemSocioeconomico = new JMenuItem("Novo Cadastro Socioeconomico");
		
		menuAtendimento.add(menuItemAtendimento);
		menuRelatorio.add(menuItemRelatorio);
		menuServico.add(menuItemServico);
		menuSocioeconomico.add(menuItemSocioeconomico);
		
		menuBar.add(menuAtendimento);
		menuBar.add(menuSocioeconomico);
		menuBar.add(menuServico);
		menuBar.add(menuRelatorio);
		
		add(menuBar,constraints);
		
	}
}
