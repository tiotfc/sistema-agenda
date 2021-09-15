package br.com.sada.sistema.agenda.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.Email;
import br.com.sada.sistema.agenda.model.Endereco;
import br.com.sada.sistema.agenda.model.Telefone;

public class ContatoDto {

	private String nome;
	private String sobreNome;
	private LocalDate dataNascimento;
	private String apelido;
	private List<EnderecoDto> listaEnderecos;
	private List<TelefoneDto> listaTelefones;
	private List<EmailDto> listaEmails;
	
	public String getNome() {
		return nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public String getApelido() {
		return apelido;
	}
	public List<EnderecoDto> getListaEnderecos() {
		return listaEnderecos;
	}
	public List<TelefoneDto> getListaTelefones() {
		return listaTelefones;
	}
	public List<EmailDto> getListaEmails() {
		return listaEmails;
	}
	
	public Contato toContato() {
//		Endereco endereco = new Endereco(0, null, apelido, 0, sobreNome, null, nome, apelido);
//		Telefone telefone = new Telefone(null, 0, 0, 0);
//		Email email = new Email(0, null, apelido);
		
		List<Endereco> listaEnderecos = new ArrayList<>();
		List<Telefone> listaTelefone = new ArrayList<>();
		List<Email> listaEmail = new ArrayList<>();
		
		listaEnderecos.stream().forEach(item -> {
			listaEnderecos.add(new Endereco(item.getTipoEndereco(), item.getRua(), item.getNumero(), item.getBairro(), item.getEstado(), item.getPais(), item.getCep()));
		});
		
		listaTelefone.stream().forEach(item -> {
			listaTelefone.add(new Telefone(item.getTipoTelefone(), item.getDdi(), item.getDdd(), item.getTelefone()));
		});
		
		listaEmail.stream().forEach(item -> {
			listaEmail.add(new Email(item.getTipoEmail(), item.getEmail()));
		});
		
		return new Contato(this.nome, this.sobreNome, this.dataNascimento, this.apelido, listaTelefone, listaEnderecos, listaEmail);
	}
	
}
