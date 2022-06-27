package com.FunkoStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.Boleta;

@Repository
public interface BoletaDAO extends CrudRepository<Boleta, Long>{
	
	public List<Boleta> findAll();
	
	public Optional<Boleta> findById(Long id);
}
