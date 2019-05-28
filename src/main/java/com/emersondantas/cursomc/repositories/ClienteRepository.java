package com.emersondantas.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emersondantas.cursomc.domain.Cliente;
import com.emersondantas.cursomc.domain.Estado;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
