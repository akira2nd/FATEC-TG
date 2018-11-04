package com.fatec.tg.janelas.popup;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.janelas.paineis.PainelMembroFamiliar;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class MembroFamiliarFrame extends JDialog {
	
	private PainelMembroFamiliar painelMembroFamiliar;

	@Autowired
	public MembroFamiliarFrame(PainelMembroFamiliar painelMembroFamiliar) {
		this.painelMembroFamiliar = painelMembroFamiliar;
		
		configFrame();
		iniciaComponentes();
		pack();
		setLocationRelativeTo(null);
	}

	private void configFrame() {
		setTitle("dados do componente");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
	}

	private void iniciaComponentes() {
		add(painelMembroFamiliar, BorderLayout.PAGE_START);
	}
	
	
	
}
