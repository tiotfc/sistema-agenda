package br.com.sada.sistema.agenda.model.enums;

public enum TipoTelefone {

	RESIDENCIAL(1), 
	COMERCIAL(2), 
	CELULAR(3);

	private int tipoTelefone;

	TipoTelefone(int valor) {
		tipoTelefone = valor;

	}

	public int getTipoTelefone() {
		return tipoTelefone;
	}
}
