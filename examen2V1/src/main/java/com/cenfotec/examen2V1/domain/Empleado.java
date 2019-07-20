package com.cenfotec.examen2V1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEmpleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_finca")
	private Long id_finca;
	
	@Column(name="cedula")
	private String cedula;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="estado")
	private String estado;

	public Empleado(Long id_finca, String cedula, String nombre, String apellido, String rol, String estado) {
		this.id_finca = id_finca;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.estado = estado;
	}
	
	public Empleado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_finca() {
		return id_finca;
	}

	public void setId_finca(Long id_finca) {
		this.id_finca = id_finca;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
