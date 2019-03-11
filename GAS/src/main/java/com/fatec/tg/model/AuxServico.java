package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="aux_servico")
public class AuxServico {
	
	// TODO arrumar
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_aux_servico")
	private Integer id;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private String turma;
	
	private String status;
	
	private boolean dispSemana;
	
	private boolean dispSabados;
	
	private boolean cursou;
	
	private boolean concluiu;
	
	private String motivo;
	
	private String interesse;
	

}
