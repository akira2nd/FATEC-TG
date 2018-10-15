package com.fatec.tg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="atendimento")
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_atendimento")
	private Integer id;
	
	@Column(name="data_atendimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtendimento;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="motivo_contato")
	private String motivoContato;
	
	@Column(name="forma_contato")
	private String formaDeContato;
	
	@Lob
	@Column(name="observacoes", length=512)
	private String observacoes;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	
}
