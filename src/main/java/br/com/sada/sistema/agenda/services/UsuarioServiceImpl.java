package br.com.sada.sistema.agenda.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.Usuario;
import br.com.sada.sistema.agenda.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl {
	private final UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario buscarPorEmail(String username) {
		return usuarioRepository.findByEmail(username)
				.orElseThrow(() -> new EntityNotFoundException("Usuário #{username} não encontrado"));
	}

	public Usuario buscarPorId(Integer id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuário #{username} não encontrado"));
	}
}
