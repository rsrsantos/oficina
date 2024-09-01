package br.com.oficina.model;

import java.util.List;

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
@Table(name="pessoa_juridica")
@Entity
public class PessoaJuridica extends AbstractEntity<Long>{
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	@NotBlank
	@Column(nullable=false)
	private String cnpj;
	
	@NotBlank
	@Column(nullable=false)
	private String razao_social;
	
	@NotBlank
	@Column(nullable=false)
	private String nome_fantasia;
	
	@NotBlank
	@Column(nullable=false)
	private String inscricao_estadual;
	
	@NotBlank
	@Column(nullable=false)
	private String inscricao_municipal;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa")
	private Pessoa pessoa;
	

}
