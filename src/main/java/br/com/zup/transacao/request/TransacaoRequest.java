package br.com.zup.transacao.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.model.Transacao;

public class TransacaoRequest {
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private Estabelecimento estabelecimentoclass;
	
	@NotNull
	private Cartao cartaoclass;

	public TransacaoRequest(@NotNull BigDecimal valor, @NotBlank Estabelecimento estabelecimentoclass,
			@NotBlank Cartao cartaoclass) {
		super();
		this.valor = valor;
		this.estabelecimentoclass = estabelecimentoclass;
		this.cartaoclass = cartaoclass;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimentoclass;
	}

	public Cartao getCartao() {
		return cartaoclass;
	}
	
	/*
	 * public Transacao toModel() {
	 * 
	 * return new Transacao(valor, new
	 * Estabelecimento(estabelecimentoclass.getNome(),estabelecimentoclass.getCidade
	 * (), estabelecimentoclass.getEndereco()) ,new
	 * Cartao(cartaoclass.getNumeroCartao(), cartaoclass.getEmail())); }
	 */

}
