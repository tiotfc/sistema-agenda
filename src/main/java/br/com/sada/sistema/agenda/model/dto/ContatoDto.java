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
		
		List<Endereco> listaEnderecos = new ArrayList<>();
		List<Telefone> listaTelefones = new ArrayList<>();
		List<Email> listaEmails = new ArrayList<>();
		Contato contato = new Contato(this.nome, this.sobreNome, this.dataNascimento, this.apelido, listaTelefones, listaEnderecos, listaEmails);
		
		this.listaEnderecos.stream().forEach(item -> {
			Endereco endereco = new Endereco(item.getTipoEndereco(), item.getRua(), item.getNumero(), item.getBairro(), item.getEstado(), item.getPais(), item.getCep());
			endereco.setContato(contato);
			listaEnderecos.add(endereco);
		});
		
		this.listaTelefones.stream().forEach(item -> {
			Telefone telefone = new Telefone(item.getTipoTelefone(), item.getDdi(), item.getDdd(), item.getTelefone());
			telefone.setContato(contato);
			listaTelefones.add(telefone);
		});
		
		this.listaEmails.stream().forEach(item -> {
			Email email = new Email(item.getTipoEmail(), item.getEmail());
			email.setContato(contato);
			listaEmails.add(email);
		});
		
		return contato;
	}
	
}
