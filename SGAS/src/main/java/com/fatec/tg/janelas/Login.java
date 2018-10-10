package com.fatec.tg.janelas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.model.Usuario;
import com.fatec.tg.service.UsuarioService;

@Component
public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	@Autowired
	private UsuarioService usuarioService;
	
	public Login() {
		super("SGAS - Login");
	}
	
	@PostConstruct
	private void iniciaComponentes() {
		
		
		JPanel painelGeral = new JPanel(new GridBagLayout());
		textFieldUsuario = new JTextField(30);
		passwordField = new JPasswordField(30);
		JButton buttonLogar = new JButton("Logar");
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		textFieldUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Usuário"));
		passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Senha"));
		buttonLogar.setActionCommand("logar");
		buttonLogar.addActionListener(this);
		
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.NONE;
		
		painelGeral.add(textFieldUsuario, constraints);
		
		constraints.gridy = 1;
		painelGeral.add(passwordField,constraints);
		
		constraints.gridy = 2;
		painelGeral.add(buttonLogar,constraints);
		setPreferredSize(new Dimension(400, 300));
		
		add(painelGeral);
		
		pack();
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event) {
		
		switch (event.getActionCommand()) {
		case "logar":
			
			Usuario usuario = usuarioService.localizaUsuarioPorEmail(textFieldUsuario.getText());
			if(usuario != null) {
				boolean compara = false;
				compara = usuario.getSenha().equals(DigestUtils.md5Hex(passwordField.getText()));
				if(compara) {
					new Principal().setVisible(true);
					this.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Senha errada!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
				System.out.println("nok");
			}
			
			break;

		default:
			break;
		}

	}

}
