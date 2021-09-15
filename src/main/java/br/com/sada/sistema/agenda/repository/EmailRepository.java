package br.com.sada.sistema.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.agenda.model.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
