package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="despesa")
public class Despesa{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="valor")
	private Double valor;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="caminho")
	private String caminho;
	
	@Column(name="ativo")
	private boolean ativo;
	
	
	
}
