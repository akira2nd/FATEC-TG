package com.fatec.tg.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="saude")
public class Saude {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_saude")
	private Integer id;
	
	@Column(name="observacao")
	private String observacao;
	
	@OneToOne
	private Socioeconomico socioeconomico;

	
}
