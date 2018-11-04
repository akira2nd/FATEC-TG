package com.fatec.tg;

import javax.swing.UIManager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.fatec.tg.controller.LoginController;


@SpringBootApplication
public class Sgas1Application {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Sgas1Application.class).headless(false).run(args);
		LoginController loginController = context.getBean(LoginController.class);
		loginController.abrir();
	}
}
