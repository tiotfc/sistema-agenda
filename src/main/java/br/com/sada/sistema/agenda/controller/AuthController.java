package br.com.sada.sistema.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.agenda.model.dto.FormLogin;
import br.com.sada.sistema.agenda.model.dto.TokenDto;
import br.com.sada.sistema.agenda.security.TokenService;
import br.com.sada.sistema.agenda.services.kafka.KafkaProducerService;
import br.com.sada.sistema.auditoria.model.dto.LogAuditoriaDto;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("auth")
@Api(tags = "Autenticação")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager; 
	@Autowired
	private KafkaProducerService kafkaProducerService;
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<TokenDto> autentica(@RequestBody FormLogin formLogin){
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(formLogin.getEmail(),formLogin.getSenha());
		Authentication authenticate = authenticationManager.authenticate(authentication);
		String token = tokenService.gerarToken(authenticate);
		
		kafkaProducerService.enviaLogAuditoria(new LogAuditoriaDto("Auditoria - AuthController - Login", tokenService.pegarIdUsuario(token)));
		
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	}
}
