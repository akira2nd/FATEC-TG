package com.fatec.tg.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="permissao")
public class Permissao {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_permissao")
	private Integer id;
	
	@Column(name="permissao")
	private String permissao;
}
