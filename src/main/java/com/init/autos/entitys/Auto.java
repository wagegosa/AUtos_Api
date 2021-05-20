package com.init.autos.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOMOVIL")
public class Auto {

	//Declaramos la variable para la base de datos
	//Declaramos el nombre, que sea ID y auto-incrementable
	@Id
	@Column(name = "id_automovil")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_automovil;
	// Asignamos el nombre, not null y el tamaño
	@Column(name = "marca_Auto", nullable = false, length = 256)
	private String marca_Auto;
	// Asignamos el nombre, not null y el tamaño
	@Column(name = "color", nullable = false, length = 256)
	private String color;
	// Asignamos el nombre, not null y el tamaño
	@Column(name = "Numero_pasajeros", nullable = false, length = 256)
	private String Numero_pasajeros;
	// Asignamos el nombre, not null y el tamaño
	@Column(name = "placa", nullable = false, length = 256)
	private String 	placa;
	
	public Long getId_automovil() {
		return id_automovil;
	}
	public void setId_automovil(Long id_automovil) {
		this.id_automovil = id_automovil;
	}
	public String getMarca_Auto() {
		return marca_Auto;
	}
	public void setMarca_Auto(String marca_Auto) {
		this.marca_Auto = marca_Auto;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumero_pasajeros() {
		return Numero_pasajeros;
	}
	public void setNumero_pasajeros(String numero_pasajeros) {
		Numero_pasajeros = numero_pasajeros;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
