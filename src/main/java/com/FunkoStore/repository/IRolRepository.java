package com.FunkoStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FunkoStore.model.*;

@Repository
public interface IRolRepository  extends JpaRepository<Roll , String>{

}
