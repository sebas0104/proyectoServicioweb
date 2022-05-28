package com.FunkoStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.producto;

@Repository
public interface IProductoRepository extends JpaRepository<producto, String> {

}
