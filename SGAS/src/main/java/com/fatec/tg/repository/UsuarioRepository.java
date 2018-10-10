package com.fatec.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.tg.model.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByEmail(String email);
}
