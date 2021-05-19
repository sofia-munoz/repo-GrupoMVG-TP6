package ar.edu.unju.fi.tp6.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTOS")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="prod_codigo", nullable = false)
	private int codigo;
	
	@Column(name="prod_nombre")
	private String nombre;
	
	@Column(name="prod_precio")
	private double precio;
	
	@Column(name="prod_marca")
	private String marca;
	
	@Column(name="prod_stock")
	private int stock;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<Compra> compras = new ArrayList<>();
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(Long id, int codigo, String nombre, double precio, String marca, int stock) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca="
				+ marca + ", stock=" + stock + "]";
	}
	
}
