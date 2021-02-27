package br.com.zup.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
	
	//TypedQuery<Cartao> query = manager.createQuery(" select c from Cartao c where numero = :numero", Cartao.class);
    //query.setParameter("numero", id);
    //List<Cartao> resultList = query.getResultList();
	
	/*
	 * @Query("SELECT c from Cartao c where c.numero = :numero AND c.id = :id")
	 * public List<Cartao> findByNumeroCartaoAndId(@Param("numero") String
	 * numero, @Param("id")String id);
	 */

}
