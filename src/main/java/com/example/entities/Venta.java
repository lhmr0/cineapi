package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombrepelicula;
	private int duracionpelicula;
	private String tipoestreno;// E, N
	private String horapelicula;//12:30
	private String salapelicula;
	private String nombrecliente;
	private String dnicliente;//12345678
	private String asiento;
	private int cantidad;
	private String tipopago;// EFECTIVO - TARJETA
	private double montopago;

	public Venta() {
		super();
	}
	
	public String getHorapelicula() {
		return horapelicula;
	}

	public void setHorapelicula(String horapelicula) {
		this.horapelicula = horapelicula;
	}

	public String getSalapelicula() {
		return salapelicula;
	}

	public void setSalapelicula(String salapelicula) {
		this.salapelicula = salapelicula;
	}

	public String getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(String dnicliente) {
		this.dnicliente = dnicliente;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public String getNombrepelicula() {
		return nombrepelicula;
	}

	public void setNombrepelicula(String nombrepelicula) {
		this.nombrepelicula = nombrepelicula;
	}

	public int getDuracionpelicula() {
		return duracionpelicula;
	}

	public String getTipoestreno() {
		return tipoestreno;
	}

	public void setTipoestreno(String tipoestreno) {
		this.tipoestreno = tipoestreno;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public void setDuracionpelicula(int duracionpelicula) {
		this.duracionpelicula = duracionpelicula;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public double getMontopago() {
		return montopago;
	}

	public void setMontopago(double montopago) {
		this.montopago = montopago;
	}

}
