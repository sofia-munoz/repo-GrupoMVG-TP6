package ar.edu.unju.fi.tp6.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Cliente;
import ar.edu.unju.fi.tp6.service.IClienteService;
import ar.edu.unju.fi.tp6.util.TablaClientes;

@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService {

	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	private List<Cliente> clientes;
	
	@Override
	public void generarTablaClientes() {
		clientes = TablaClientes.registrosClientes;
		LOGGER.info("METHOD: generarTablaClientes ---- Se genero la tabla de clientes");
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		if(clientes == null)
			generarTablaClientes();
		clientes.add(cliente);
		LOGGER.info("METHOD: guardarCliente ---- Se agrego un objeto cliente en la lista: " + cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		return clientes;
	}

	
}
