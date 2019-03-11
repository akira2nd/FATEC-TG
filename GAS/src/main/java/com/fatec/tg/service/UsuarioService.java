package com.fatec.tg.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fatec.tg.model.Permissao;
import com.fatec.tg.model.Usuario;
import com.fatec.tg.repository.PermissaoRepository;
import com.fatec.tg.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService {
	private UsuarioRepository usuarioRepository;
	private PermissaoRepository permissaoRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, PermissaoRepository permissaoRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.permissaoRepository = permissaoRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public Usuario localizaUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void salvarUsuario(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuario.setAtivo(1);
		Permissao usuarioPermissao = permissaoRepository.findByPermissao("ADMIN");
		usuario.setPermissoes(new HashSet<Permissao>(Arrays.asList(usuarioPermissao)));
		usuarioRepository.save(usuario);
	}
	
}
