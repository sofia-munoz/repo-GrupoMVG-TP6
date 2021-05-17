package ar.edu.unju.fi.tp6.service;

import java.util.List;

import ar.edu.unju.fi.tp6.model.Compra;

public interface ICompraService {
	
	public void generarTablaCompras();
	public void guardarCompra(Compra compra);
	public List<Compra> getCompras();
	public Compra consultarUltimaCompra();
	
}
