package br.com.sada.sistema.agenda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.dto.ContatoDto;
import br.com.sada.sistema.agenda.repository.ContatoRepository;
import br.com.sada.sistema.agenda.services.kafka.KafkaProducerService;
import br.com.sada.sistema.auditoria.model.dto.LogAuditoriaDto;

@Service
public class ContatoServiceImpl {

	private ContatoRepository contatoRepository;
	private UsuarioServiceImpl usuarioSerive;
	private KafkaProducerService kafkaProducerService;

	public ContatoServiceImpl(ContatoRepository contatoRepository, UsuarioServiceImpl usuarioSerive,
			KafkaProducerService kafkaProducerService) {
		this.contatoRepository = contatoRepository;
		this.usuarioSerive = usuarioSerive;
		this.kafkaProducerService = kafkaProducerService;
	}

	public Contato save(ContatoDto contatoDto) {
		Contato contato = contatoDto.toContato();
		contato.setUsuario(usuarioSerive.buscarPorId(contatoDto.getUsuarioId()));
		kafkaProducerService.enviaLogAuditoria(new LogAuditoriaDto("Auditoria - ContatoServiceImpl - save", contato.getUsuario().getId()));
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
		kafkaProducerService.enviaLogAuditoria(new LogAuditoriaDto("Auditoria - ContatoServiceImpl - listContatosByUsuario", usuarioId));
		return contatoRepository.findAllByUsuarioId(usuarioId);
	}
	
	public void deleteById(int id) {
		contatoRepository.deleteById(id);
	}

	public Contato findContatoByUsuario(int usuarioId, int contatoId) {
		kafkaProducerService.enviaLogAuditoria(new LogAuditoriaDto("Auditoria - ContatoServiceImpl - findContatoByUsuario", usuarioId));
		return contatoRepository.findContatoByUsuarioId(usuarioId, contatoId);
	}

}
