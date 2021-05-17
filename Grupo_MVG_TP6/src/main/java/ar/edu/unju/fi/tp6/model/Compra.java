package ar.edu.unju.fi.tp6.model;

import org.springframework.stereotype.Component;

@Component
public class Compra {
	private int codigo;
	private Producto producto;
	private int cantidad;
	private double total;
	
	public Compra() {
		super();
	}

	public Compra(int codigo, Producto producto, int cantidad, double total) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total
				+ "]";
	}
	
}
