package com.FunkoStore.repository;

import com.FunkoStore.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<categoria, String> {


}
