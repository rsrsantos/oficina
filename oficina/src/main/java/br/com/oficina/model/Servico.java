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
@Table(name="servico")
@Entity
public class Servico extends AbstractEntity<Long>{
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private int Qtde;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_servico_categoria")
	private ServicoCategoria servicoCategoria;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_servico_local")
	private ServicoLocal servicoLocal;
	
	

}
