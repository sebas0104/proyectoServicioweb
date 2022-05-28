package com.FunkoStore.controller;

import com.FunkoStore.model.*;
import com.FunkoStore.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/login")
public class UsuarioController {
	@Autowired
	private IUsuarioRepository repou;
	@GetMapping("/cargar")
	public String cargarPag(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	
	@PostMapping("/validar")
	public String grabarPag(@ModelAttribute Usuario usuario, Model model) {
		System.out.println("Listo para grabar");
		System.out.println(usuario);
		Usuario u = repou.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		System.out.println(u);
		//validacion
		if(u==null) {
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("mensaje", "Ususario o clave incorrecto");
			return "login";
		}else {
			model.addAttribute("usuario", u);
			return "principal";
		}
}
}


