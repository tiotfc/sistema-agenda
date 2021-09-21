package br.com.sada.sistema.agenda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.services.UsuarioServiceImpl;


@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioService.buscarPorEmail(username);
	}
}
