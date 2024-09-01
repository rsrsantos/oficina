package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

	Orcamento findById(long id);



}
