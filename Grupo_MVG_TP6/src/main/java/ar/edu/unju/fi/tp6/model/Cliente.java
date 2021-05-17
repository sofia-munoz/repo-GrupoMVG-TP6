package ar.edu.unju.fi.tp6.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	
	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int codigoAreaTelefono;
	private int nroTelefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int edad, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido.toUpperCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	public int getEdad() {
		Period periodo = Period.between(fechaNacimiento, LocalDate.now());
		int edad = periodo.getYears();
		return edad;
	}
	
	public String getTiempoDesdeUltimaCompra() {
		Period periodo = Period.between(fechaUltimaCompra, LocalDate.now());
		String tiempo = "Años: " + periodo.getYears() + " - Meses: " + periodo.getMonths() + " - Dias: " + periodo.getDays();
		return tiempo;
	}
	
	public long getTiempoDesdeFechaNacimiento() {
		Calendar hoy = Calendar.getInstance();
		Calendar fNacimiento = Calendar.getInstance();
		fNacimiento.set(fechaNacimiento.getYear(), fechaNacimiento.getMonthValue()-1, fechaNacimiento.getDayOfMonth());
		long tiempo = hoy.getTimeInMillis() - fNacimiento.getTimeInMillis();
		long dias = tiempo/1000/60/60/24;
		return dias;
	}
	
	public String getTiempoHastaCumpleanios() {
		LocalDate fechaProximoCumpleanios;
		LocalDate cumple = fechaNacimiento.withYear(LocalDate.now().getYear());
		if(cumple.isBefore(LocalDate.now())) {
			fechaProximoCumpleanios = fechaNacimiento.withYear(LocalDate.now().getYear()+1);
		}
		else
			fechaProximoCumpleanios = fechaNacimiento.withYear(LocalDate.now().getYear());
		
		Period periodo = Period.between(LocalDate.now(), fechaProximoCumpleanios);
		
		LocalDateTime fechaProximoCumpleaniosConHora = LocalDateTime.of(fechaProximoCumpleanios.getYear(), fechaProximoCumpleanios.getMonthValue(), fechaProximoCumpleanios.getDayOfMonth(), 0, 0, 0);
		Duration duracion = Duration.between(LocalDateTime.now(), fechaProximoCumpleaniosConHora);
		String tiempo = periodo.getDays() + " Dias - " + periodo.getMonths() + " Meses - " + periodo.getYears() + " Año - " + duracion.toHoursPart() + " Horas - " + duracion.toMinutesPart() + " Min - " + duracion.toSecondsPart() + " Seg";
		return tiempo;
	}

	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono=" + nroTelefono
				+ ", fechaUltimaCompra=" + fechaUltimaCompra + ", getEdad()=" + getEdad()
				+ ", getTiempoDesdeUltimaCompra()=" + getTiempoDesdeUltimaCompra()
				+ ", getTiempoDesdeFechaNacimiento()=" + getTiempoDesdeFechaNacimiento()
				+ ", getTiempoHastaCumpleanios()=" + getTiempoHastaCumpleanios() + "]";
	}
	
}
