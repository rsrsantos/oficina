package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Cliente;
import br.com.oficina.model.Condutor;
import br.com.oficina.model.Marca;
import br.com.oficina.model.PessoaEndereco;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {

	Condutor findById(long id);



}
