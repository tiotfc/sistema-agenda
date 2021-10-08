package br.com.sada.sistema.agenda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.dto.ContatoDto;
import br.com.sada.sistema.agenda.repository.ContatoRepository;

@Service
public class ContatoServiceImpl {

	private ContatoRepository contatoRepository;
	private UsuarioServiceImpl usuarioSerive;


	public ContatoServiceImpl(ContatoRepository contatoRepository, UsuarioServiceImpl usuarioSerive) {
		super();
		this.contatoRepository = contatoRepository;
		this.usuarioSerive = usuarioSerive;
	}

	public Contato save(ContatoDto contatoDto) {
		Contato contato = contatoDto.toContato();
		contato.setUsuario(usuarioSerive.buscarPorId(contatoDto.getUsuarioId()));
		return contatoRepository.save(contato);
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
	
	public List<Contato> listContatosByUsuario(int usuarioId) {
		return contatoRepository.findAllByUsuarioId(usuarioId);
	}
	
	public void deleteById(int id) {
		contatoRepository.deleteById(id);
	}

	public Contato findContatoByUsuario(int usuarioId, int contatoId) {
		return contatoRepository.findContatoByUsuarioId(usuarioId, contatoId);
	}

}
