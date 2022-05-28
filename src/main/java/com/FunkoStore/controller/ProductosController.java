package com.FunkoStore.controller;
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
@RequestMapping(path ="/producto")
public class ProductosController {

	@Autowired
	private IProductoRepository repo;
	
	@Autowired
	private ICategoriaRepository repocate;
	
	
	
	@GetMapping("/cargar")
	public String cargarpag(Model model) {
		model.addAttribute("producto", new producto());
		model.addAttribute("lstCa",repocate.findAll());
		return "crudproductos";
	}
	
	@GetMapping("/cargarinicio")
	public String cargarpaginicio(Model model) {
				return "principal";
	}


	@PostMapping("/grabar")
	public String grabarpag(@ModelAttribute producto producto,Model model) {
		System.out.println("Listo para grabar ");
		System.out.println(producto);
		repo.save(producto);// merge
		model.addAttribute("lstCa",repocate.findAll());
		return "crudproductos";
	}

	@GetMapping("/listar")
	public String listadodeProductos(Model model) {
		model.addAttribute("lstPro",repo.findAll());
		return "listadoProductos";
	}
		
	
	@PostMapping("/Actualizar")
	public String buscarProducto(@ModelAttribute producto p, Model model) {
		System.out.println(p);
		model.addAttribute("producto",repo.findById(p.getIdproducto()));
		model.addAttribute("lstCa",repocate.findAll());
		return "actualizarproductos";
	}
	
	
	@PostMapping("/eliminar")
	public String eliminarlibro(@ModelAttribute producto p,Model model) {
		System.out.println("Listo para eliminar ");
		System.out.println(p);
		repo.deleteById(p.getIdproducto());
		model.addAttribute("lstCa",repocate.findAll());
		model.addAttribute("lstPro",repo.findAll());
		return "listadoProductos";

	}
	
	
	
	@PostMapping("/editar")
	public String grabarpag2(@ModelAttribute producto producto,Model model) {
		System.out.println("Listo para grabar ");
		System.out.println(producto);
		repo.save(producto);// merge
		model.addAttribute("lstCa",repocate.findAll());
		return "crudproductos";
	}
}
