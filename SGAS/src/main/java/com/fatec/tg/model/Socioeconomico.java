package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="socioeconomico")
public class Socioeconomico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_socioeconomico")
	private Integer id;
	
	@Column(name="nome_responsavel")
	private String nomeResponsavel;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@Column(name="num_rg")
	private String numRg;
	
	@Column(name="num_cpf")
	private String numCpf;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="estado_civil")
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@Column(name="escolaridade")
	@Enumerated(EnumType.STRING)
	private Escolaridade escolaridade;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="pofissao")
	private String profissao;
	
	@Column(name="funcao")
	private String funcao;
	
	@Column(name="renda", scale=2, length=10)
	private Double renda;
	

}
