package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.model.evento.CartaoEvento;
import br.com.zup.transacao.model.evento.EstabelecimentoEvento;
import br.com.zup.transacao.repository.CartaoRepository;

public class EventoDeTransacao {

	private String id;

	private BigDecimal valor;

	@NotNull
    private EstabelecimentoEvento estabelecimento;
    @NotNull
    private CartaoEvento cartao;
	
	private LocalDateTime efetivadaEm;
	


	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoEvento getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoEvento getCartao() {
		return cartao;
	}


	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toModel() {
        return new Transacao(id, valor, new Cartao(cartao.getId(), cartao.getEmail()), new Estabelecimento(estabelecimento.getNome(),
        		estabelecimento.getCidade(), estabelecimento.getEndereco()), efetivadaEm);
    }

}
