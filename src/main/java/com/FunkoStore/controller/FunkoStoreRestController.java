package com.FunkoStore.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FunkoStore.model.Boleta;
import com.FunkoStore.model.Cliente;
import com.FunkoStore.model.Producto;
import com.FunkoStore.response.http.HttpResponseObject;
import com.FunkoStore.services.BoletaServiceImpl;
import com.FunkoStore.services.ClienteServiceImpl;
import com.FunkoStore.services.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class FunkoStoreRestController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private ClienteServiceImpl clienteService;

	@Autowired
	private BoletaServiceImpl boletaService;

	@Autowired
	private ProductoServiceImpl productoService;

	@GetMapping("clientes/lista")
	public HttpResponseObject obtenerClientes() {
		List<Cliente> clientes = clienteService.listarCliente();
		if (clientes.size() == 0) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, clientes);
	}

	@GetMapping("boleta/lista")
	public HttpResponseObject obtenerBoleta() {
		List<Boleta> boletas = boletaService.listarBoleta();
		if (boletas.size() == 0) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, boletas);
	}

	@GetMapping("boleta/lista/{id}")
	public HttpResponseObject obtenerBoletaFecha(@PathVariable(name = "id") Long id) {
		Boleta boletas = this.boletaService.listarBoletaId(id);
		if (boletas == null) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, boletas);
	}

	@GetMapping("producto/lista")
	public HttpResponseObject obtenerProducto() {
		List<Producto> productos = productoService.listarProductos();
		if (productos.size() == 0) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, productos);
	}

	@GetMapping("producto/lista/{id}")
	public HttpResponseObject obtenerProductoId(@PathVariable(name = "id") Long id) {
		Producto producto = this.productoService.obtenerProducto(id);
		if (producto == null) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, producto);
	}

	@PostMapping(value = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(rollbackFor = Exception.class)
	public HttpResponseObject guardarProducto(@RequestBody Producto productoB) {
		try {
			Producto producto = this.productoService.guardarProducto(productoB);
			return new HttpResponseObject("success", HttpStatus.OK, producto);
		} catch (Exception e) {
			return new HttpResponseObject("success", HttpStatus.OK, null);
		}
	}

	@DeleteMapping(value = "/producto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(rollbackFor = Exception.class)
	public HttpResponseObject eliminarProducto(@PathVariable(name = "id") Long id) {
		try {
			productoService.eliminarProducto(id);
			return new HttpResponseObject("success", HttpStatus.OK, "eliminado");
		} catch (Exception e) {
			return new HttpResponseObject("success", HttpStatus.OK, null);
		}
	}
}
