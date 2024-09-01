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
@Table(name="ordem_servico")
@Entity
public class OrdemServico extends AbstractEntity<Long>{
	
	private String numOs;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_entidade")
	private Entidade entidade;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date horaEntrada;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date previsaoInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pervisaoEntrega;
	
	private String observacao;
	
	@Column(nullable=false, length=2)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_orcamento")
	private Orcamento orcamento;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_veiculo")
	private Veiculo veiculo;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_vendedor")
	private Vendedor vendedor;
	
	
	

}
