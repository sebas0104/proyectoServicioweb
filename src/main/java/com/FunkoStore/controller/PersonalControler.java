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
@RequestMapping(path = "/personal")
public class PersonalControler {
	@Autowired
	private IpersonalRepository repoper;

	@Autowired
	private IRolRepository reporol;

	@GetMapping("/cargar")
	public String cargarpag(Model model) {
		model.addAttribute("personal", new Personal());
		model.addAttribute("lstro", reporol.findAll());
		return "crudPersonal";
	}

	@PostMapping("/grabar")
	public String grabarpag(@ModelAttribute Personal Personal, Model model) {
		System.out.println("Listo para grabar ");
		System.out.println(Personal);
		repoper.save(Personal);// merge
		model.addAttribute("lstro", reporol.findAll());
		return "crudPersonal";

	}

	@GetMapping("/listar")
	public String listadodePersonal(Model model) {
		model.addAttribute("lstPer", repoper.findAll());
		return "listadoPersonal";
	}

	@PostMapping("/editar")
	public String buscarPersonal(@ModelAttribute Personal per, Model model) {
		System.out.println(per);
		model.addAttribute("personal", repoper.findById(per.getIdpersonal()));
		model.addAttribute("lstro", reporol.findAll());
		return "Reduciendo Personal";
	}

	@PostMapping("/eliminar")
	public String eliminarlibro(@ModelAttribute Personal per, Model model) {
		System.out.println("Listo para eliminar ");
		System.out.println(per);
		repoper.deleteById(per.getIdpersonal());
		model.addAttribute("lstro", reporol.findAll());
		model.addAttribute("lstPer", repoper.findAll());
		return "listadoPersonal";

	}

}
