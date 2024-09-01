package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Garantia;
import br.com.oficina.model.PessoaEndereco;

@Repository
public interface GarantiaRepository extends JpaRepository<Garantia, Long> {

	Garantia findById(long id);



}
