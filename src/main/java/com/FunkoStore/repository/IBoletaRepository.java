package com.FunkoStore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.Boleta;

@Repository
public interface IBoletaRepository extends CrudRepository<Boleta, Long>{
	
	public List<Boleta> findAll();
}
