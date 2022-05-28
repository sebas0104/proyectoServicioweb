package com.FunkoStore.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.FunkoStore.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCorreoAndClave(String correo, String clave);
}
