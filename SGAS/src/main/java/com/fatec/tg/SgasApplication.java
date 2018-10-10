package com.fatec.tg;

import javax.swing.UIManager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.fatec.tg.janelas.Login;

@SpringBootApplication
public class SgasApplication {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SgasApplication.class).headless(false).run(args);
		Login loginFrame = context.getBean(Login.class);
		loginFrame.setVisible(true);
	}
}
