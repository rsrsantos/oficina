package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.ProdutoTipo;

@Repository
public interface ProdutoTipoRepository extends JpaRepository<ProdutoTipo, Long> {

	ProdutoTipo findById(long id);



}
