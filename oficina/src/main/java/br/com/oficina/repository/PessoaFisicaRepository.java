package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

	PessoaFisica findById(long id);



}
