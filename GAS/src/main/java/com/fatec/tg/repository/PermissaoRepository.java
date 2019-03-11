package com.fatec.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.tg.model.Permissao;

@Repository("permissaoRepository")
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {
	Permissao findByPermissao(String permissao);
}
