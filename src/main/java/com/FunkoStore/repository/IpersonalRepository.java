package com.FunkoStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.Personal;

@Repository
public interface IpersonalRepository  extends JpaRepository<Personal, Integer>{

	
}
