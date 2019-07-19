package com.cenfotec.examen2V1.domain;

import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TFinca")
public class Finca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="espacio")
	private double espacio;
	
	public Finca(String nombre, String direccion, String espacio) throws ParseException {
		this.nombre = nombre;
		this.direccion = direccion;
		this.espacio = Double.parseDouble(espacio);
	}
	
	public Finca(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getEspacio() {
		return espacio;
	}

	public void setEspacio(double espacio) {
		this.espacio = espacio;
	}
}
