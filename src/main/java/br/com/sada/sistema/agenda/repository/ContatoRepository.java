package br.com.sada.sistema.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sada.sistema.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

	@Query(value = "SELECT c, u FROM Contato c, Usuario u WHERE c.usuario = u.id and u.id = :usuarioId")
	List<Contato> findAllByUsuarioId(int usuarioId);
	
	
}
