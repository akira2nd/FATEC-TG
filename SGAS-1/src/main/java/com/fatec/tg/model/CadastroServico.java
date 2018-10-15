package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="cadastro_servico")
public class CadastroServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cad_servico")
	private Integer id;
	
	@Column(name="nome_servico")
	private String nome;
	
	@Column(name="criado_em")
	private Date datacriacao;
	
	@Column(name="precisa_socioeconomico")
	private boolean precisaSocioeconomico;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@ManyToOne
	private Usuario usuario;
	

}
