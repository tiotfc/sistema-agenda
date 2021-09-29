package br.com.sada.sistema.agenda.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sada.sistema.agenda.model.Contato;
import br.com.sada.sistema.agenda.model.Email;
import br.com.sada.sistema.agenda.model.Endereco;
import br.com.sada.sistema.agenda.model.Telefone;

public class ContatoDto {

	private Integer usuarioId;
	private String nome;
	private String sobreNome;
	private LocalDate dataNascimento;
	private String apelido;
	private List<EnderecoDto> listaEnderecos;
	private List<TelefoneDto> listaTelefones;
	private List<EmailDto> listaEmails;
	
	
	public Integer getUsuarioId() {
		return usuarioId;
	}
	
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
//		List<Endereco> listaEndereco = this.listaEnderecos.stream().map(e->e.toEndereco()).collect(Collectors.toList());
		List<Endereco> listaEnderecos = this.listaEnderecos.stream().map(EnderecoDto::toEndereco).collect(Collectors.toList());
		List<Telefone> listaTelefones = this.listaTelefones.stream().map(TelefoneDto::toTelefone).collect(Collectors.toList());
		List<Email> listaEmails = this.listaEmails.stream().map(EmailDto::toEmail).collect(Collectors.toList());
		
		return new Contato(nome, sobreNome, dataNascimento, apelido, listaTelefones, listaEnderecos, listaEmails);
	}

}
