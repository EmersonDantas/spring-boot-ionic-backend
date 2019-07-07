package com.emersondantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.emersondantas.cursomc.domain.Categoria;
import com.emersondantas.cursomc.repositories.CategoriaRepository;
import com.emersondantas.cursomc.services.exceptions.DataIntegrityException;
import com.emersondantas.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class CategoriaService {
	
	@Autowired //Automaticamente instanciado pelo spring por injeção de dependência
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) throws ObjectNotFoundException{
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) throws ObjectNotFoundException {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException, DataIntegrityException {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
