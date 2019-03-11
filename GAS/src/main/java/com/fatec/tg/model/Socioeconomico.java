package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty(message="informe o nome do responsável familiar")
	private String nomeResponsavel;
	
	@Column(name="data_nascimento")
	@NotEmpty(message="informe a data de nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@Column(name="num_rg")
	@NotEmpty(message="informe o numero do RG")
	private String numRg;
	
	@Column(name="num_cpf")
	@NotEmpty(message="informe o numero do CPF")
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
