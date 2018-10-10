package com.fatec.tg.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_usuario")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="ativo")
	private int ativo;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_permissao",
	joinColumns=@JoinColumn(name="id_usuario"),
	inverseJoinColumns=@JoinColumn(name="id_permissao"))
	private Set<Permissao> permissoes;
	
	
	
}
