package com.emersondantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emersondantas.cursomc.domain.Categoria;
import com.emersondantas.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired //Automaticamente instanciado pelo spring por injeção de dependência
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obg = repo.findById(id);
		return obg.orElse(null);
	}
}
