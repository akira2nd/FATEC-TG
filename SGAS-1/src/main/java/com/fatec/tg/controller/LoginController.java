package com.fatec.tg.controller;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fatec.tg.controller.geral.UsoGeralController;
import com.fatec.tg.janelas.mestre.LoginFrame;
import com.fatec.tg.model.Usuario;
import com.fatec.tg.service.UsuarioService;

@Controller
public class LoginController extends UsoGeralController {
	
	private UsuarioService usuarioService;
	private LoginFrame loginFrame;
	private PrincipalController principalController;

	
	@Autowired
	public LoginController(UsuarioService usuarioService, LoginFrame loginFrame,
			PrincipalController principalController) {
		this.usuarioService = usuarioService;
		this.loginFrame = loginFrame;
		this.principalController = principalController;
	}

	public void abrir() {
		buttonAddAction(loginFrame.getButtonLogar(), (e) -> abrirJanelaPrincipal());
		loginFrame.setVisible(true);
	}

	private void abrirJanelaPrincipal() {
		Usuario usuario = usuarioService.localizaUsuarioPorEmail(loginFrame.getTextFieldUsuario().getText());
		if(usuario != null) {
			boolean compara = false;
			compara = usuario.getSenha().equals(DigestUtils.md5Hex(loginFrame.getPasswordField().getText()));
			if(compara) {
				principalController.setUsuario(usuario);
				principalController.abrir();
				loginFrame.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "Senha errada!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
			System.out.println("nok");
		}
	}

}
