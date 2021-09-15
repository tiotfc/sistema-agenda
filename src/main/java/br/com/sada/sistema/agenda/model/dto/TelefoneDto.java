package br.com.sada.sistema.agenda.model.dto;

import br.com.sada.sistema.agenda.model.enums.TipoTelefone;

public class TelefoneDto {

	private TipoTelefone tipoTelefone;
	private long ddi;
	private long ddd;
	private long telefone;

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

}
