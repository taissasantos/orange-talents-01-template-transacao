package br.com.zup.transacao.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Transacao {

	@Id
    private String id;

	@Column(nullable = false)
	public BigDecimal valor;

	@NotNull
	@ManyToOne(cascade = {PERSIST, MERGE})
	@JoinColumn(nullable = false)
	public Estabelecimento estabelecimento;

	@NotNull
	@ManyToOne(cascade = {PERSIST, MERGE})
	@JoinColumn(nullable = false)
	public Cartao cartao;

	@Column(nullable = false)
	private LocalDateTime efetivadaEm = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());

	@Deprecated
	Transacao(){}



	public Transacao(String id,
			@NotNull @Positive BigDecimal valor,
			@NotNull Cartao cartao,
			@NotNull Estabelecimento estabelecimento,
			@NotNull LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.cartao = cartao;
		this.estabelecimento = estabelecimento;
		this.efetivadaEm = efetivadaEm;
	}


	

	public String getId() {
		return id;
	}



	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}


	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}


}
