package ar.edu.unju.fi.tp6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "COMPRAS")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "com_codigo")
	private long codigo;
	
	@Column(name = "com_cantidad")
	private int cantidad;
	
	@Column(name = "com_total")
	private double total;
	
	@Autowired
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_codigo")
	private Producto producto;
	
	public Compra() {
		super();
	}

	public Compra(long codigo, Producto producto, int cantidad, double total) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
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
		double total = this.cantidad*this.producto.getPrecio();
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
