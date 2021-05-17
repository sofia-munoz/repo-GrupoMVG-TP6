package ar.edu.unju.fi.tp6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.IProductoService;

@Controller
public class ProductoController {

	@Autowired
	private Producto producto;
	
	@Autowired
	@Qualifier("productoUtilService")
	private IProductoService productoService;
	
	@GetMapping("/producto/nuevo")
	public String getProductoPage(Model model) {
		model.addAttribute(producto);
		return "nuevoproducto";
	}
	
	@PostMapping("/producto/guardar")
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		
		productoService.agregarProducto(producto);
		return "resultado";
		
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("productos");
		if(productoService.getProductos() == null)
			productoService.generarTablaProductos();
		model.addObject("productos", productoService.getProductos());
		return model;
	}
	
	@GetMapping("/producto/ultimo")
	public String getUltimoProductoPage(Model model) {
		model.addAttribute(productoService.consultarUltimo());
		return "ultimoproducto";
	}
	
}
