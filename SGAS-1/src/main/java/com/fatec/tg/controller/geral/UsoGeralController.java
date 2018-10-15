package com.fatec.tg.controller.geral;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

public abstract class UsoGeralController {
	
	public abstract void abrir();
	
	protected void buttonAddAction(JButton button, ActionListener actionListener) {
		button.addActionListener(actionListener);
	}
	
	protected void menuAddActionListener(JMenuItem menuItem, ActionListener actionListener) {
		menuItem.addActionListener(actionListener);
	}
	

}
