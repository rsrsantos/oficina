package br.com.oficina.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings({ "serial", "unused" })
@Getter
@Setter
@Entity
public class Garantia extends AbstractEntity<Long>{
	
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInclusao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAlteracao;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	@Column(columnDefinition = "integer default 0")
	private int statusdelete;
	
	
	
	

}
