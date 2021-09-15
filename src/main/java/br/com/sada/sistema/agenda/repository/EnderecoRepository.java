package br.com.sada.sistema.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sada.sistema.agenda.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
