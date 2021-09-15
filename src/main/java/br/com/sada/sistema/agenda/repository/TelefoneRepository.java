package br.com.sada.sistema.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.agenda.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}
