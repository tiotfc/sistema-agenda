package br.com.sada.sistema.agenda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.dto.ContatoDto;
import br.com.sada.sistema.agenda.services.ContatoServiceImpl;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	private ContatoServiceImpl contatoService;

	public ContatoController(ContatoServiceImpl contatoService) {
		super();
		this.contatoService = contatoService;
	}
	
	@PostMapping
	public Contato salvar(ContatoDto contatoDto) {
		return contatoService.save(contatoDto.toContato());
	}
	
	@GetMapping("/{id}")
	public Contato buscarPorId(@PathVariable int id) {
		return contatoService.findById(id);
	}
	
}
