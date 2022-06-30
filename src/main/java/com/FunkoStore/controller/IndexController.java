package  com.FunkoStore.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import  com.FunkoStore.model.Boleta;
import com.FunkoStore.model.Cliente;
import com.FunkoStore.model.Producto;
import com.FunkoStore.services.BoletaServiceImpl;
import com.FunkoStore.services.ClienteServiceImpl;
import com.FunkoStore.services.ProductoServiceImpl;

@Controller
@RequestMapping("/home")
public class IndexController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private ClienteServiceImpl clienteService;

	@Autowired
	private BoletaServiceImpl boletaService;

	@Autowired
	private ProductoServiceImpl productoService;

	@Value("${index.titulo.text}")
	private String title;

	@GetMapping({ "/index", "/", "" })
	public String index(Model model) {
		model.addAttribute("titulo", title);
		return "index";
	}

	@ModelAttribute("clientes")
	public List<Cliente> obtenerLista() {
		List<Cliente> clientes = clienteService.listarCliente();
		return clientes;
	}

	@ModelAttribute("boletas")
	public List<Boleta> obtenerListaBoletas() {
		List<Boleta> boletas = boletaService.listarBoleta();
		return boletas;
	}

	@ModelAttribute("productos")
	public List<Producto> obtenerListaProductos() {
		List<Producto> productos = productoService.listarProductos();
		return productos;
	}

	@GetMapping({ "/producto/{idProducto}" })
	public String obtenerProducto(Model model, @PathVariable(name = "idProducto") Long idProducto) {
		model.addAttribute("titulo", "Producto N# " + idProducto);
		Producto producto = this.productoService.obtenerProducto(idProducto);
		model.addAttribute("producto", producto);
		return "producto";
	}
	
	@GetMapping({"/nuevoProducto"})
	public String agregar(Model model) {
		model.addAttribute("producto", new Producto());
		return "producto";
	}
	
	@PostMapping({"/guardar"})
	public String nuevoProducto(Producto producto, Model model) {
		productoService.guardarProducto(producto);
		return "index";
	}
	
	@GetMapping({"/eliminar/{idProducto}"})
	public String eliminarProducto(Model model, @PathVariable(name = "idProducto") Long id) {
		productoService.eliminarProducto(id);
		return "index";
	}

}
