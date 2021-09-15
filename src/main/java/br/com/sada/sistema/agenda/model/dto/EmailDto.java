package br.com.sada.sistema.agenda.model.dto;

import br.com.sada.sistema.agenda.model.enums.TipoEmail;

public class EmailDto {
	private TipoEmail tipoEmail;
	private String email;

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public String getEmail() {
		return email;
	}

}
