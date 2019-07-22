package com.cenfotec.examen2V1.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TProduccion")
public class Produccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_finca")
	private Long id_finca;
	
	@Column(name="cant_huevos")
	private int cant_huevos;
	
	@Column(name="fecha")
	private LocalDate fecha = LocalDate.now();
	
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public String getCreatedAsShort() {
		return format.format(fecha);
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

	public int getCant_huevos() {
		return cant_huevos;
	}

	public void setCant_huevos(int cant_huevos) {
		this.cant_huevos = cant_huevos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) throws ParseException {
		this.fecha = fecha;
	}
	
	public Produccion() {
	}
}
