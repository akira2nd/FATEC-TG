package com.fatec.tg.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.tg.model.Permissao;
import com.fatec.tg.model.Usuario;
import com.fatec.tg.repository.PermissaoRepository;
import com.fatec.tg.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService {
	private UsuarioRepository usuarioRepository;
	private PermissaoRepository permissaoRepository;

	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, PermissaoRepository permissaoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.permissaoRepository = permissaoRepository;
	}

	public Usuario localizaUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void salvarUsuario(Usuario usuario) {
		String hash = DigestUtils.md5Hex(usuario.getSenha());
		usuario.setSenha(hash);
		usuario.setAtivo(1);
		Permissao usuarioPermissao = permissaoRepository.findByPermissao("ADMIN");
		usuario.setPermissoes(new HashSet<Permissao>(Arrays.asList(usuarioPermissao)));
		usuarioRepository.save(usuario);
	}
	
}
