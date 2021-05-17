package ar.edu.unju.fi.tp6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteUtilService")
	private IClienteService clienteSerice;
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoCliente(Model model) {
		model.addAttribute(cliente);
		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView guardarClientePage(@ModelAttribute("cliente")Cliente cliente) {
		ModelAndView model = new ModelAndView("clientes");
		clienteSerice.guardarCliente(cliente);
		model.addObject("clientes", clienteSerice.getClientes());
		return model;
	}
	
	@GetMapping("/cliente/listado")
	public ModelAndView getListadoPage() {
		ModelAndView model = new ModelAndView("clientes");
		if(clienteSerice.getClientes() == null)
			clienteSerice.generarTablaClientes();
		model.addObject("clientes", clienteSerice.getClientes());
		return model;
	}
}
