package br.com.sada.sistema.agenda.model.enums;

public enum TipoEmail {
	
	PESSOAL(1),
	COMERCIAL(2);

	private int tipoEmail;
	
	
	TipoEmail(int valor) {
		tipoEmail = valor;
	
	}
	
	public int getTipoTelefone() {
		return tipoEmail;
		
	}
}
