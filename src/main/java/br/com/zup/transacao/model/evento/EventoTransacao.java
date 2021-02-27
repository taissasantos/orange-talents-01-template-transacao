package br.com.zup.transacao.model.evento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.CartaoRepository;

public class EventoTransacao {
	
	@NotBlank
    private String id;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    private EstabelecimentoEvento estabelecimento;
    @NotNull
    private CartaoEvento cartao;
    @NotNull
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

    public Transacao toModel(EntityManager manager, CartaoRepository cartaoRepository) {
        return new Transacao(id, valor, new Cartao(cartao.getId(), cartao.getEmail()), new Estabelecimento(estabelecimento.getNome(),
        		estabelecimento.getCidade(), estabelecimento.getEndereco()), efetivadaEm);
    }

}
