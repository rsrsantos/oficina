package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.ProdutoCategoria;

@Repository
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Long> {

	ProdutoCategoria findById(long id);



}
