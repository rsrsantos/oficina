package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

	Marca findById(long id);



}
