package br.com.sada.sistema.agenda.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

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
		return Collections.unmodifiableList(listaTelefones);
	}

	public List<Endereco> getListaEnderecos() {
		return Collections.unmodifiableList(listaEnderecos);
	}

	public List<Email> getListaEmails() {
		return Collections.unmodifiableList(listaEmails);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, nome, sobreNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobreNome, other.sobreNome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	public void setListaEmails(List<Email> listaEmails) {
		this.listaEmails = listaEmails;
	}
	
	
	

	
	
}
