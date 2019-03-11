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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
	@NotEmpty(message="Informe o seu nome")
	private String nome;
	
	@Column(name="email")
	@Email(message="Digite um e-mail válido")
	@NotEmpty(message="Digite um e-mail")
	private String email;
	
	@Column(name="senha")
	@NotEmpty(message="Digite a senha")
	@Length(min= 5, message= "A senha deve ter no mínimo 5 caracteres")
	private String senha;
	
	@Column(name="ativo")
	private int ativo;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_permissao",
	joinColumns=@JoinColumn(name="id_usuario"),
	inverseJoinColumns=@JoinColumn(name="id_permissao"))
	private Set<Permissao> permissoes;
	
	
	
}
