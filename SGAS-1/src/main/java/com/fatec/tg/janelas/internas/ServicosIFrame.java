package com.fatec.tg.janelas.internas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.springframework.stereotype.Component;

import com.fatec.tg.janelas.paineis.PainelDadosAluno;
import com.fatec.tg.janelas.paineis.PainelResponsavel;
import com.fatec.tg.janelas.paineis.PainelServicoCurso;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@Component
public class ServicosIFrame extends JInternalFrame {
	
	private PainelServicoCurso painelServicoCurso;
	private PainelResponsavel painelResponsavel;
	private PainelDadosAluno painelDadosAluno;
	private PainelAdicionalCurso painelAdicionalCurso;
	private JPanel painelGeral;
	private JScrollPane scrollPaneGeral;
	
	public ServicosIFrame(PainelServicoCurso painelServicoCurso, PainelResponsavel painelResponsavel,
			PainelDadosAluno painelDadosAluno, PainelAdicionalCurso painelAdicionalCurso) {

		this.painelServicoCurso = painelServicoCurso;
		this.painelResponsavel = painelResponsavel;
		this.painelDadosAluno = painelDadosAluno;
		this.painelAdicionalCurso = painelAdicionalCurso;
		
		configFrame();
		iniciaComponentes();
		pack();
		scrollPaneGeral.setPreferredSize(new Dimension(getWidth(),(int) (getHeight() * 0.30)));
	}
	
	private void configFrame() {
		setTitle("Serviços e Cursos");
		setClosable(true);
		setLayout(new GridBagLayout());
		
	}
	private void iniciaComponentes() {
		painelGeral = new JPanel(new GridLayout(0, 1));
		scrollPaneGeral = new JScrollPane(painelGeral);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.WEST;
		
		painelGeral.add(painelServicoCurso);
		painelGeral.add(painelResponsavel);
		painelGeral.add(painelDadosAluno);
		painelGeral.add(painelAdicionalCurso);
		
		add(scrollPaneGeral);

	}
	// TODO arrumar disposição gridbaglayout!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//TODO montar janela de serviços e cursos.. e aplicar as regras do controller
	

}
