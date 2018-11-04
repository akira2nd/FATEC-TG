package com.fatec.tg.janelas.internas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fatec.tg.janelas.paineis.PainelDespesas;
import com.fatec.tg.janelas.paineis.PainelHabitacao;
import com.fatec.tg.janelas.paineis.PainelResponsavelFamiliar;
import com.fatec.tg.janelas.paineis.PainelSaude;
import com.fatec.tg.janelas.popup.MembroFamiliarFrame;
import com.fatec.tg.model.MembroFamiliar;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class SocioeconomicoIFrame extends JInternalFrame{
	
	private PainelResponsavelFamiliar painelResponsavel;
	private MembroFamiliarFrame membroFamiliarFrame;
	private JPanel painelNomeMembro;
	private JButton buttonAddMembro;
	private PainelHabitacao painelHabitacao;
	private PainelSaude painelSaude;
	private PainelDespesas painelDespesas;
	private Set<MembroFamiliar> listaMembroFamiliar; 
	private JButton buttonSalvar;
	private JScrollPane scrollPaneGeral;
	
	
	@Autowired
	public SocioeconomicoIFrame(PainelResponsavelFamiliar painelResponsavel, MembroFamiliarFrame membroFamiliarFrame,
			PainelHabitacao painelHabitacao, PainelSaude painelSaude, PainelDespesas painelDespesas) {
		this.painelResponsavel = painelResponsavel;
		this.membroFamiliarFrame = membroFamiliarFrame;
		this.painelHabitacao = painelHabitacao;
		this.painelSaude = painelSaude;
		this.painelDespesas = painelDespesas;
		
		configFrame();
		iniciaComponentes();
		pack();
		System.out.println(getSize());
		scrollPaneGeral.setPreferredSize(new Dimension(getWidth(),(int) (getHeight() * 0.58)));
		
	}
	

	private void configFrame() {
		
		setTitle("Novo Cadastro Socioeconomico");
		setClosable(true);
		setLayout(new GridBagLayout());
		
	}
	

	
	private void iniciaComponentes() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		System.out.println(tk.getScreenSize());
		/*java.awt.Dimension[width=1920,height=1080]
		java.awt.Dimension[width=1604,height=726]
		*/
		painelNomeMembro = new JPanel(new GridLayout(0,2));
		painelNomeMembro.setBorder(BorderFactory.createTitledBorder("Membro(s) da família"));
		buttonAddMembro = new JButton("Adicionar Membro");
		JPanel painelGeral = new JPanel(new GridBagLayout());
		scrollPaneGeral = new JScrollPane(painelGeral);

		buttonSalvar = new JButton("Salvar");
		// TODO metade do tamanho da tela
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		painelGeral.add(painelResponsavel, constraints);
		constraints.gridy = 1;
		painelGeral.add(painelNomeMembro,constraints);
		constraints.gridy = 2;
		painelGeral.add(buttonAddMembro, constraints);
		constraints.gridy = 3;
		painelGeral.add(painelHabitacao,constraints);
		constraints.gridy = 4;
		painelGeral.add(painelDespesas,constraints);
		
		
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(scrollPaneGeral, constraints);
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(buttonSalvar, constraints);
	}
	
	


}
