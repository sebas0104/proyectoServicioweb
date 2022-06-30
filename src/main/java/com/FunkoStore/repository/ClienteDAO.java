package com.FunkoStore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.Cliente;

@Repository
public interface ClienteDAO extends CrudRepository<Cliente, Long>{

	public List<Cliente> findAll();
}
