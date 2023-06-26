package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "videojuego")
public class Videojuego {
	@GeneratedValue(generator = "seq_videojuego",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_videojuego",sequenceName = "seq_videojuego",allocationSize = 1)
	@Id
	@Column(name="vdjo_id")
	private Integer id;
	@Column(name= "vdjo_costo")
	private BigDecimal costo;
	@Column(name = "vdjo_nombre")
	private String nombre;
	@Column(name = "vdjo_plataforma")
	private String plataforma;
	
	//SET AND GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", costo=" + costo + ", nombre=" + nombre + ", plataforma=" + plataforma + "]";
	}
	
	
	
	
	

}
