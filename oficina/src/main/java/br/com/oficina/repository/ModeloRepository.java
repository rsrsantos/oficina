package br.com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oficina.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	Modelo findById(long id);



}
