package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name="membro_familiar")
public class MembroFamiliar {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_membro")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="data_nascimento")
	@NotEmpty(message="informe a data de nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@Column(name="parentesco")
	private String parentesco;
	
	@Column(name="estudante")
	private String estudante;
	
	@Column(name="serie")
	private String serie;
	
	@Column(name="turno")
	private String turno;
	
	@Column(name="renda")
	private String renda;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_socioeconomico")
	private Socioeconomico socioeconomico;
	
	@Column(name="ativo")
	private int ativo;
	
}
