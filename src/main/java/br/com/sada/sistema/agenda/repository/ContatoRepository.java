package br.com.sada.sistema.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
