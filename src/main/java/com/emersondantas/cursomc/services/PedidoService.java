package com.emersondantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emersondantas.cursomc.domain.Pedido;
import com.emersondantas.cursomc.repositories.PedidoRepository;
import com.emersondantas.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired //Automaticamente instanciado pelo spring por injeção de dependência
	private PedidoRepository repo;
	
	public Pedido find(Integer id) throws ObjectNotFoundException{
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
