package com.fatec.tg.model;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="habitacao")
public class Habitacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_habitacao")
	private Integer id;
	
	@Column(name="tipo_de_construcao")
	private String tipoConstrucao;
	
	@Column(name="numero_comodos")
	private Integer numComodos;
	
	@Column(name="possui_automovel")
	private boolean temAutomovel;
	
	@Column(name="ano_veiculo")
	private Integer ano;
	
	@Column(name="marca")
	private String marca;
	
	@OneToOne
	private Socioeconomico socioeconomico;

}
