package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.PessoaContato;

@Repository
public interface PessoaContatoRepository extends JpaRepository<PessoaContato, Long> {

	PessoaContato findById(long id);



}
