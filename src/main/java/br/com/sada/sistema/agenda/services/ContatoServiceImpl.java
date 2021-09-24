package br.com.sada.sistema.agenda.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.Email;
import br.com.sada.sistema.agenda.model.Endereco;
import br.com.sada.sistema.agenda.model.Telefone;
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
		return contatoRepository.save(converteToContato(contatoDto));
	}

	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

	public Contato findById(int id) {
		return contatoRepository.findById(id).get();
	}
	public List<Contato> listContatoByUser(int usuarioId) {
		return contatoRepository.findAllByUsuarioId(usuarioId);
	}
	
	
	public Contato converteToContato(ContatoDto contatoDto) {
		List<Endereco> listaEnderecos = new ArrayList<>();
		List<Telefone> listaTelefones = new ArrayList<>();
		List<Email> listaEmails = new ArrayList<>();
		Contato contato = new Contato(contatoDto.getNome(), contatoDto.getSobreNome(), contatoDto.getDataNascimento(), contatoDto.getApelido(), listaTelefones, listaEnderecos, listaEmails);
		
		contatoDto.getListaEnderecos().stream().forEach(item -> {
			Endereco endereco = new Endereco(item.getTipoEndereco(), item.getRua(), item.getNumero(), item.getBairro(), item.getEstado(), item.getPais(), item.getCep());
			endereco.setContato(contato);
			listaEnderecos.add(endereco);
		});
		
		contatoDto.getListaTelefones().stream().forEach(item -> {
			Telefone telefone = new Telefone(item.getTipoTelefone(), item.getDdi(), item.getDdd(), item.getTelefone());
			telefone.setContato(contato);
			listaTelefones.add(telefone);
		});
		
		contatoDto.getListaEmails().stream().forEach(item -> {
			Email email = new Email(item.getTipoEmail(), item.getEmail());
			email.setContato(contato);
			listaEmails.add(email);
		});
		
		contato.setUsuario(usuarioSerive.buscarPorId(contatoDto.getUsuarioId()));
		
		return contato;
		
	}

}
