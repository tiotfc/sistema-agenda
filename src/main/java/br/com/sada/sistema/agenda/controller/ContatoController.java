package br.com.sada.sistema.agenda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.dto.ContatoDto;
import br.com.sada.sistema.agenda.services.ContatoServiceImpl;

@RestController
@RequestMapping("/contatos/")
public class ContatoController {

	private ContatoServiceImpl contatoService;

	public ContatoController(ContatoServiceImpl contatoService) {
		super();
		this.contatoService = contatoService;
	}
	
	@PostMapping
	public Contato salvar(@RequestBody ContatoDto contatoDto) {
		return contatoService.save(contatoDto.toContato());
	}
	
	@GetMapping("/{id}")
	public Contato buscarPorId(@PathVariable int id) {
		return contatoService.findById(id);
	}
	
	@GetMapping("/")
	public List<Contato> listarContatos() {
		return contatoService.findAll();
	}
	
}
