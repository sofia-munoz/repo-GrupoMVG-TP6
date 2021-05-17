package ar.edu.unju.fi.tp6.service;

import java.util.List;

import ar.edu.unju.fi.tp6.model.Cliente;

public interface IClienteService {

	public void generarTablaClientes();
	public void guardarCliente(Cliente cliente);
	public List<Cliente> getClientes();
}
