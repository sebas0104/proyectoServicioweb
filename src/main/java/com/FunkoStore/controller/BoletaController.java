package com.FunkoStore.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FunkoStore.model.Boleta;
import com.FunkoStore.model.Cliente;
import com.FunkoStore.response.http.HttpResponseObject;
import com.FunkoStore.services.BoletaServiceImpl;

@RestController
@RequestMapping("/api")
public class BoletaController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private BoletaServiceImpl boletaServiceImpl;
	
	@GetMapping("/cargar")
	public String cargarpag(Model model) {
		return "ReporteBoletas";
	}
	@GetMapping("boletas/lista")
	public HttpResponseObject obtenerBoleta() {
		List<Boleta> clientes = boletaServiceImpl.listarBoleta();
		if (clientes.size() == 0) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, clientes);
	}

}
