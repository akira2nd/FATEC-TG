package com.fatec.tg.janelas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.model.Usuario;


public class Principal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private JPanel painelFrameInterno = new JPanel(new GridBagLayout());
	@Autowired
	private FrameAtendimento frameAtendimento;
	
	public Principal() {
		super("SGAS - Sistema Gerenciador de Atendimentos e Serviços");
		iniciaComponentes();
	}

	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private void iniciaComponentes() {
		
		JPanel painelGeral = new JPanel(new GridBagLayout());
		JPanel painelCabeca = new JPanel(new GridBagLayout());
		JLabel labelUsuario = new JLabel("Bem Vindo " + usuario.getNome() + "("+ usuario.getEmail() + ")");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		
		URL urlLogo1 = getClass().getResource("/imagens/logo1.png");
		URL urlLogo2 = getClass().getResource("/imagens/obra-socialfinal.png");
		URL urlLogo3 = getClass().getResource("/imagens/logo.png");
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuAtendimento = new JMenu("Atendimento ");
		JMenu menuSocioeconomico = new JMenu("Acompanhamento_Socioeconomico ");
		JMenu menuServicos = new JMenu("Registro_Serviços/Cursos ");
		JMenu menuRelatorios = new JMenu("Relatórios ");
		
		JMenuItem menuItemAtendimento = new JMenuItem("Novo Atendimento");
		menuItemAtendimento.setActionCommand("atendimento");
		menuItemAtendimento.addActionListener(this);
		menuAtendimento.add(menuItemAtendimento);
		
		JMenuItem menuItemSocioeconomico = new JMenuItem("Novo Cadastro Socioeconomico");
		menuItemSocioeconomico.setActionCommand("socioeconomico");
		menuItemSocioeconomico.addActionListener(this);
		menuSocioeconomico.add(menuItemSocioeconomico);
		
		JMenuItem menuItemServicos = new JMenuItem("Novo Cadastro Serviço/Curso");
		menuItemServicos.setActionCommand("servicos");
		menuItemServicos.addActionListener(this);
		menuServicos.add(menuItemServicos);
		
		menuBar.add(menuAtendimento);
		menuBar.add(menuSocioeconomico);
		menuBar.add(menuServicos);
		menuBar.add(menuRelatorios);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		painelGeral.add(painelCabeca,constraints);
		painelCabeca.add(new JLabel(new ImageIcon(urlLogo1)),constraints);
		
		constraints.gridx = 1;
		painelCabeca.add(new JLabel(new ImageIcon(urlLogo2)),constraints);
		
		constraints.gridx = 3;
		painelCabeca.add(new JLabel(new ImageIcon(urlLogo3)),constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		painelGeral.add(menuBar, constraints);
		painelCabeca.add(labelUsuario,constraints);
		
		constraints.gridy = 2;
		painelGeral.add(painelFrameInterno, constraints);

		
		

		add(painelGeral, BorderLayout.PAGE_START);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		//setResizable(false);
		pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		
		painelFrameInterno.removeAll();
		System.out.println(evt.getActionCommand());
		switch (evt.getActionCommand()) {
		case "atendimento":
			painelFrameInterno.add(frameAtendimento,constraints);
			System.out.println("ok");
			break;

		default:
			break;
		}

	}

}
