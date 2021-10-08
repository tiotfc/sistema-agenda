package br.com.sada.sistema.agenda.model.dto;

public class ContatoUpdateDto {

	private int usuarioId;
	private int contatoId;
	private ContatoDto contato;

	public int getUsuarioId() {
		return usuarioId;
	}

	public int getContatoId() {
		return contatoId;
	}

	public ContatoDto getContato() {
		return contato;
	}

}
