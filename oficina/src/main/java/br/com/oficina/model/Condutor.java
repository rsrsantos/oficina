package br.com.oficina.model;

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
@Table(name="condutor")
@Entity
public class Condutor extends AbstractEntity<Long>{
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_inclusao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_alteracao;
	
	private String habilitacao;
	
	private String categoria;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa")
	private Pessoa pessoa;
	

}
