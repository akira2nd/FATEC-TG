package com.fatec.tg.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="dados_do_servico")
public class DadosDoServico {
	
	// TODO arrumar ??
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_dados_servico")
	private Integer id;
	@OneToOne
	private CadastroServico cadastroServico;
	@OneToOne
	private Socioeconomico socioeconomico;
	@OneToOne
	private MembroFamiliar membroFamiliar;
	
	private Integer fonecontato;
	
	private boolean temLaptop;
}
