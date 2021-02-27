package br.com.zup.transacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.TransacaoRepository;
import br.com.zup.transacao.request.TransacaoRequest;

@RestController
public class TransacaoController {

	@Autowired
	TransacaoRepository transacaoRepository;
	
	
	@PostMapping(value = "/api/transacao")
	public ResponseEntity<?>cria(@RequestBody @Valid TransacaoRequest request){
		//Transacao transacao = request.toModel();
		//transacaoRepository.save(transacao);	
		return ResponseEntity.ok().build();
		
	}
}
