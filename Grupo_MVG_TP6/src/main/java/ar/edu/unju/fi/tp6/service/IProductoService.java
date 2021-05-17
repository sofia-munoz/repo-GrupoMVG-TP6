package ar.edu.unju.fi.tp6.service;

import java.util.List;

import ar.edu.unju.fi.tp6.model.Producto;

public interface IProductoService {
	
	public void generarTablaProductos();
	public void agregarProducto(Producto producto);
	public List<Producto> getProductos();
	public Producto consultarUltimo();

	public Producto getProductoPorCodigo(int codigo);
}
