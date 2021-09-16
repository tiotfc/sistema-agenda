package br.com.sada.sistema.agenda.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobreNome;
	private LocalDate dataNascimento;
	private String apelido;

	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Telefone> listaTelefones = new ArrayList<>();

	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Endereco> listaEnderecos = new ArrayList<>();

	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Email> listaEmails = new ArrayList<>();

	public Contato(String nome, String sobreNome, LocalDate dataNascimento, String apelido,
			List<Telefone> listaTelefones, List<Endereco> listaEnderecos, List<Email> listaEmails) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.listaTelefones = listaTelefones;
		this.listaEnderecos = listaEnderecos;
		this.listaEmails = listaEmails;
	}
	
	public Contato() {
	}

	
	public Integer getId() {
		return id;
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

	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public List<Email> getListaEmails() {
		return listaEmails;
	}

	public void adicionaEndereco(Endereco endereco) {
		endereco.setContato(this);
		listaEnderecos.add(endereco);
		
	}
	
	public void adicionaTelefone(Telefone telefone) {
		telefone.setContato(this);
		listaTelefones.add(telefone);
	}
	
	public void adicionaEmail(Email email) {
		email.setContato(this);
		listaEmails.add(email);
	}

}
