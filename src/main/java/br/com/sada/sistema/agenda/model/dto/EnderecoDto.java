package br.com.sada.sistema.agenda.model.dto;

import br.com.sada.sistema.agenda.model.Endereco;
import br.com.sada.sistema.agenda.model.enums.Estados;
import br.com.sada.sistema.agenda.model.enums.TipoEndereco;

public class EnderecoDto {

	private TipoEndereco tipoEndereco;
	private String rua;
	private int numero;
	private String bairro;
	private Estados estado;
	private String pais;
	private String cep;

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

	public Endereco toEndereco() {
		return new Endereco(tipoEndereco, rua, numero, bairro, estado, pais, cep);
	}
	
}
