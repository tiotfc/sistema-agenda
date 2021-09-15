package br.com.sada.sistema.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	private Contato contato;

	public Telefone(TipoTelefone tipoTelefone, long ddi, long ddd, long telefone) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
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

}
