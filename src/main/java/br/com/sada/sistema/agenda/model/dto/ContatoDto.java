package br.com.sada.sistema.agenda.model.dto;

import java.time.LocalDate;
import java.util.List;

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

}
