package br.com.sada.sistema.agenda.controller;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.dto.ContatoDto;
import br.com.sada.sistema.agenda.services.ContatoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contatos")
@Api(tags = "Contatos")
public class ContatoController {

	private ContatoServiceImpl contatoService;

	public ContatoController(ContatoServiceImpl contatoService) {
		super();
		this.contatoService = contatoService;
	}
	
	@ApiOperation(value = "Metodo para salvar novos contatos.")
	@PreAuthorize("#contatoDto.usuarioId==authentication.principal.id")
	@PostMapping()
	public Contato salvar(@RequestBody ContatoDto contatoDto) {
		return contatoService.save(contatoDto);
	}
	
	@ApiOperation(value = "Metodo para buscar um contato pelo id, de acordo com o usuario logado.")
	@PostAuthorize("#usuarioId==authentication.principal.id")
	@GetMapping("/{usuarioId}/{contatoId}")
	public Contato buscarPorId(@PathVariable int usuarioId, @PathVariable int contatoId) {
		return contatoService.findContatoByUsuario(usuarioId, contatoId);
	}
	
	@ApiOperation(value = "Metodo para listar contatos, de acordo com o usuario logado.")
	@PreAuthorize("#usuarioId==authentication.principal.id")
	@GetMapping("/lista/{usuarioId}")
	public List<Contato> listarContatos(@PathVariable int usuarioId) {
		return contatoService.listContatosByUsuario(usuarioId);
	}
	
	@ApiOperation(value = "Metodo para deletar um contato pelo id, de acordo com o usuario logado.")
	@PostAuthorize("#usuarioId==authentication.principal.id")
	@DeleteMapping("/{usuarioId}/{contatoId}")
	public void deletarContato(@PathVariable int usuarioId, @PathVariable int contatoId) {
		contatoService.deleteById(contatoId);
	}

}
