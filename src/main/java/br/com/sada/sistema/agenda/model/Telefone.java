package br.com.sada.sistema.agenda.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sada.sistema.agenda.model.enums.TipoTelefone;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private TipoTelefone tipoTelefone;
	private long ddi;
	private long ddd;
	private long telefone;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Contato contato;

	public Telefone(TipoTelefone tipoTelefone, long ddi, long ddd, long telefone) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public Telefone() {
	}
	
	public int getId() {
		return id;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public long getDdi() {
		return ddi;
	}

	public long getDdd() {
		return ddd;
	}

	public long getTelefone() {
		return telefone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, ddd, ddi, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(contato, other.contato) && ddd == other.ddd && ddi == other.ddi
				&& telefone == other.telefone;
	}

}
