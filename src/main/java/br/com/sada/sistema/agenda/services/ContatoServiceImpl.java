package br.com.sada.sistema.agenda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.repository.ContatoRepository;

@Service
public class ContatoServiceImpl {

	private ContatoRepository contatoRepository;

	public ContatoServiceImpl(ContatoRepository contatoRepository) {
		super();
		this.contatoRepository = contatoRepository;
	}

	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}

	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

	public Contato findById(int id) {
		return contatoRepository.findById(id).get();
	}

}
