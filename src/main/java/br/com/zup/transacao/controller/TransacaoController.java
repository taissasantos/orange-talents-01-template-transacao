package br.com.zup.transacao.controller;

import static org.springframework.data.domain.Sort.Direction.DESC;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;
import br.com.zup.transacao.response.TransacaoResponse;

@RestController
public class TransacaoController {

	@Autowired
	TransacaoRepository transacaoRepository;

	@PersistenceContext
	EntityManager manager;


	@GetMapping(value = "/api/transacao/{id}")
	public ResponseEntity<Page<TransacaoResponse>> buscarUltimasTransacoes(@PathVariable("id") Long id,
			@PageableDefault(size = 10, sort = "efetivadaEm", direction = DESC) Pageable pageable){

		Cartao cartao = manager.find(Cartao.class, id);
        if (cartao == null) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado " + id);
        }
            
		Page<TransacaoResponse> transacoes = transacaoRepository.findByCartaoId(id, pageable)
				.map(TransacaoResponse::new);

		return ResponseEntity.status(HttpStatus.OK).body(transacoes);

	}
}
