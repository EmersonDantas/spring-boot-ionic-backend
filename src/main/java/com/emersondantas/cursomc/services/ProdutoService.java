package com.emersondantas.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.emersondantas.cursomc.domain.Categoria;
import com.emersondantas.cursomc.domain.Produto;
import com.emersondantas.cursomc.repositories.CategoriaRepository;
import com.emersondantas.cursomc.repositories.ProdutoRepository;
import com.emersondantas.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ProdutoService {
	
	@Autowired //Automaticamente instanciado pelo spring por injeção de dependência
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) throws ObjectNotFoundException{
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
