package br.com.sada.sistema.agenda.model.enums;

public enum TipoEndereco {

	RESIDENCIAL(1), 
	COMERCIAL(2);

	private int tipoEndereco;

	TipoEndereco(int valor) {
		tipoEndereco = valor;

	}

	public int getTipoEndereco() {
		return tipoEndereco;
	}
}
