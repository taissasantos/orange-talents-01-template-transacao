package br.com.zup.transacao.model.evento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.util.Assert;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.repository.CartaoRepository;

public class CartaoEvento {
	
	private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

	/*
	 * public Cartao toModel(CartaoRepository cartaoRepository) {
	 * 
	 * Cartao cartao = new Cartao(); List<Cartao> resultList =
	 * cartaoRepository.findByNumeroCartaoAndId(cartao.getNumero(), id);
	 * 
	 * Assert.state(resultList.size() <= 1,
	 * "Mais de um cartão igual foi encontrado.");
	 * 
	 * if (resultList.isEmpty()) return new Cartao(id, email); else return
	 * resultList.get(0); }
	 */

}
