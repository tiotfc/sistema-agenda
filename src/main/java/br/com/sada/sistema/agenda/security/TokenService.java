package br.com.sada.sistema.agenda.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	private String chave = "CHAVE23QWERTY";
	private Integer expiracao = 180000;
	
	public String gerarToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date DataExpiracao = new Date(hoje.getTime() + expiracao);
		return Jwts.builder()
				.setSubject(usuario.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(DataExpiracao)
				.signWith(SignatureAlgorithm.HS512, chave)
				.compact();
	}
	
	public boolean isValido(String token) {
		try {
			Jwts.parser().setSigningKey(chave).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Integer pegarIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(chave).parseClaimsJws(token).getBody();
		return Integer.parseInt(claims.getSubject());
	}
}
