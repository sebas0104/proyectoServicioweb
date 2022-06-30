/*package com.FunkoStore.controller;

import com.FunkoStore.model.*;
import com.FunkoStore.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path ="/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteRepository repocli;

	@GetMapping("/cargar")
	public String cargarpag(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "crudCliente";
	}


	@PostMapping("/grabar")
	public String grabarpag(@ModelAttribute Cliente cli,Model model) {
		System.out.println("Listo para grabar ");
		System.out.println(cli);
		repocli.save(cli);// merge
	    return "crudCliente";

	}

	@GetMapping("/listar")
	public String listadodeProductos(Model model) {
		model.addAttribute("lstCli",repocli.findAll());
		return "listadoCliente";
	}

	@PostMapping("/editar")
	public String buscarProducto(@ModelAttribute Cliente cli, Model model) {
		
	System.out.println("----- Editar-----");
	System.out.println(cli);
	model.addAttribute("cliente",repocli.findById(cli.getIdcliente()));
	return "ReduciendoCliente";
	}
	
	@PostMapping("/eliminar")
	public String eliminarlibro(@ModelAttribute Cliente cli, Model model) {
		System.out.println("Listo para eliminar ");
		System.out.println(cli.toString());
		repocli.deleteById(cli.getIdcliente());
		model.addAttribute("lstCli",repocli.findAll());
		return "listadoCliente";
	
	}
}*/
