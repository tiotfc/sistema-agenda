package br.com.sada.sistema.agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sada.sistema.agenda.model.enums.Estados;
import br.com.sada.sistema.agenda.model.enums.TipoEndereco;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private TipoEndereco tipoEndereco;
	private String rua;
	private int numero;
	private String bairro;
	private Estados estado;
	private String pais;
	private String cep;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Contato contato;

	public Endereco(TipoEndereco tipoEndereco, String rua, int numero, String bairro, Estados estado,
			String pais, String cep) {
		super();
		this.tipoEndereco = tipoEndereco;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	public Endereco() {
	}
	
	public int getId() {
		return id;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public Estados getEstado() {
		return estado;
	}

	public String getPais() {
		return pais;
	}

	public String getCep() {
		return cep;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
