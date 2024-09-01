package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.PessoaEndereco;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {

	PessoaEndereco findById(long id);



}
