package ar.edu.unju.fi.tp6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.model.Compra;
import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.ICompraService;
import ar.edu.unju.fi.tp6.service.IProductoService;

@Controller
public class CompraController {

	
	@Autowired
	private Compra compra;
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	@Autowired
	@Qualifier("productoUtilService")
	private IProductoService productoService;
	
	@GetMapping("/compra/nueva")
	public String getCompraNuevaPage(Model model) {
		model.addAttribute("compra", compra);
		model.addAttribute("productos", productoService.getProductos());
		return "compranueva";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView getGuardarCompraPage(@ModelAttribute("compra")Compra compra) {
		ModelAndView model = new ModelAndView("compras");
		Producto producto = productoService.getProductoPorCodigo(compra.getProducto().getCodigo());
		compra.setProducto(producto);
		compra.setTotal(compra.getCantidad()*producto.getPrecio());
		compraService.guardarCompra(compra);
		model.addObject("compras", compraService.getCompras());
		return model;
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getListadoCompraPage() {
		ModelAndView model = new ModelAndView("compras");
		if(compraService.getCompras() == null)
			compraService.generarTablaCompras();
		model.addObject("compras", compraService.getCompras());
		return model;
	}
	
	@GetMapping("/compra/ultima")
	public String getCompraUltimoPage(Model model) {
		model.addAttribute(compraService.consultarUltimaCompra());
		return "ultimacompra";
	}
}
