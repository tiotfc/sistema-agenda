package br.com.sada.sistema.agenda.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sada.sistema.agenda.model.enums.TipoEmail;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private TipoEmail tipoEmail;
	private String email;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Contato contato;

	public Email(TipoEmail tipoEmail, String email) {
		super();
		this.tipoEmail = tipoEmail;
		this.email = email;
	}

	public Email() {
	}

	public int getId() {
		return id;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public String getEmail() {
		return email;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(contato, other.contato) && Objects.equals(email, other.email);
	}
	
	public void associaContato(Contato contato) {
		this.contato = contato;
	}

}
