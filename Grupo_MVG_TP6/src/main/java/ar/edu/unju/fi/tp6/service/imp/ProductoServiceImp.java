package ar.edu.unju.fi.tp6.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.model.Producto;
import ar.edu.unju.fi.tp6.service.IProductoService;
import ar.edu.unju.fi.tp6.util.TablaProductos;

@Service("productoUtilService")
public class ProductoServiceImp implements IProductoService{

	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	private List<Producto> productos = new ArrayList<Producto>();

	@Override
	public void generarTablaProductos() {
		productos = TablaProductos.registrosProductos;
		LOGGER.info("METHOD: generarTablaClientes ---- Se genero la tabla de productos");
	}
	
	@Override
	public void agregarProducto(Producto producto) {
		if(productos == null) {
			generarTablaProductos();
		}
		productos.add(producto);
		LOGGER.info("METHOD: agregarProducto ---- Se agrego un objeto producto en la lista: "+productos.get(productos.size()-1));
		
	}

	@Override
	public List<Producto> getProductos() {
		return productos;
	}
	
	@Override
	public Producto consultarUltimo() {
		
		Producto ultimo = productos.get(productos.size()-1);
		LOGGER.info("METHOD: consultarUltimo ---- Se devuelve un objeto producto de la lista: "+ultimo);
		return ultimo;
		
	}

	@Override
	public Producto getProductoPorCodigo(int codigo) {
		Producto prod = new Producto();
		for(Producto p: productos) {
			if(p.getCodigo()==codigo) {
				prod = p;
			}
		}
		return prod;
	}
	
}
