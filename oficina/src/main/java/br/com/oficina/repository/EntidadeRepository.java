package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Cliente;
import br.com.oficina.model.Entidade;
import br.com.oficina.model.Marca;
import br.com.oficina.model.PessoaEndereco;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long> {

	Entidade findById(long id);



}
